plugins {
    java
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.inject:guice:5.0.1")

    implementation("org.jetbrains:annotations:13.0")
}

application {
    mainClass.set("guice_homework.Main")
}

tasks.register<JavaExec>("startMainClass") {
    group = "launch"
    mainClass.set("guice_homework.Main")
    standardInput = System.`in`
    classpath = sourceSets["main"].runtimeClasspath
    args("2", "mytag")
}
