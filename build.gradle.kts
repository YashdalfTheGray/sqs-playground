// import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
    }
}

repositories {
    mavenCentral()
}

plugins {
    application
    kotlin("jvm") version "1.3.72"
    // id("com.github.johnrengelman.shadow") version "5.2.0"
    // Need a resolution to https://github.com/johnrengelman/shadow/issues/336
    // before we can add Shadow back into the build
}

application {
    mainClass.set("com.yashdalfthegray.sqsplayground.MainKt")
}

// tasks {
//     named<ShadowJar>("shadowJar") {
//         mainClass.set("com.yashdalfthegray.sqsplayground.MainKt")
//         minimize()
//    }
// }

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(platform("software.amazon.awssdk:bom:2.13.9"))

    implementation("software.amazon.awssdk:sqs")
}

sourceSets.main {
    java.srcDirs("src")
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "com.yashdalfthegray.sqsplayground.MainKt"
    }

    from(configurations.runtimeClasspath.get().map({
        if (it.isDirectory) it else zipTree(it)
    }))
}
