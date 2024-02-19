import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    application

    id("io.freefair.lombok") version "8.1.0"

}



application {
    mainClass.set("org.example.hexlet.HelloWorld")
}

group = "org.example"
version = "1.0-SNAPSHOT"

//apply plugin: 'java'

repositories {
    mavenCentral()
}

/*configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

 */

dependencies {

    //compileOnly 'org.projectlombok:lombok:1.18.20'
    //annotationProcessor 'org.projectlombok:lombok:1.18.20'

    // Версии зависимостей могут отличаться
    // Здесь мы сразу подключаем зависимости,
    // которые понадобятся во время обучения

    implementation ("org.apache.commons:commons-text:1.11.0")
    implementation("io.javalin:javalin:5.6.1")
    implementation("org.slf4j:slf4j-simple:2.0.7")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("gg.jte:jte:3.0.1")
    implementation("io.javalin:javalin-rendering:5.6.2")






}



tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}