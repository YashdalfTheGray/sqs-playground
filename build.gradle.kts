plugins {
  id 'org.jetbrains.kotlin.jvm' version '1.2.21'
}

apply plugin: 'application'

repositories {
    mavenCentral()
}

dependencies {
    compile 'org.jetbrains.kotlin:kotlin-stdlib-jdk8'
}

sourceSets {
    main.kotlin.srcDirs += 'src'
}

// Define the main startup class and jar name
mainClassName = 'MainKt'
archivesBaseName = 'sqs-plyground'

// tell the jar which class to startup in.
jar {
    manifest {
        attributes 'Main-Class': 'MainKt'
    }
}
