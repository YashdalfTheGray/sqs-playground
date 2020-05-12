// include the kotlin gradle plugin as a build dependency
buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
    }
}

// tell gradle where to find dependency jars from
repositories {
    mavenCentral()
}

// add the kotlin sdtlib, aws-sdk, and specifically the sqs parts
// of the aws-sdk
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(platform("software.amazon.awssdk:bom:2.13.9"))

    implementation("software.amazon.awssdk:sqs")
}

// add (or enable) the kotlin-jvm target plugin as well as
// an executable script creator plugin
plugins {
    application
    kotlin("jvm") version "1.3.72"
}

// since we aren't following the default src/main/kotlin path
// for the kotlin files, we have to tell gradle where to find them
sourceSets.main {
    java.srcDirs("src")
}

// application plugin needs to find our main class
application {
    mainClass.set("com.yashdalfthegray.sqsplayground.MainKt")
}

// each task that builds a jar needs to know what the main class is
val jar by tasks.getting(Jar::class) {
    manifest {
        attributes("Main-Class" to "com.yashdalfthegray.sqsplayground.MainKt")
    }
}

// create a "fatjar" task so that we can package up everything into a
// single file, and then use any java runtime to run it
tasks {
  register("fatjar", Jar::class.java) {
    archiveClassifier.set("all")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes("Main-Class" to "com.yashdalfthegray.sqsplayground.MainKt")
    }

    from(
        configurations
            .runtimeClasspath
            .get()
            .onEach { logger.info("[info] fatjar - add from dependencies: ${it.name}") }
            .map { if (it.isDirectory) it else zipTree(it) }
    )

    val sourcesMain = sourceSets.main.get()
    sourcesMain
        .allSource
        .forEach { logger.info("[info] fatjar - add from sources: ${it.name}") }

    from(sourcesMain.output)
  }
}

// tell the wrapper to always only pull down the binaries when generated
tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.BIN
}
