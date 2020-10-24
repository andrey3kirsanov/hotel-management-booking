import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        gradlePluginPortal()
        maven("https://repo.spring.io/plugins-release")
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.2.RELEASE")
    }
}

plugins {
    application
    id("org.springframework.boot") version "2.3.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("kapt") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
}

group = "ru.hotel.management.hotel.booking"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-configuration-processor")

    // Kafka
    implementation("org.springframework.kafka:spring-kafka:2.5.3.RELEASE")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.8")
    testCompileOnly("org.projectlombok:lombok:1.18.8")
    annotationProcessor("org.projectlombok:lombok:1.18.8")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.8")

    // Swagger
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    implementation("io.springfox:springfox-swagger2:2.9.2")

    // Liquibase
    implementation("org.liquibase:liquibase-core")
    implementation("org.postgresql:postgresql:42.2.13")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Logging
    implementation("io.github.microutils:kotlin-logging:1.7.9")

    // Apache Commons
    implementation("org.apache.commons:commons-collections4:4.4")

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.+")

    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")

    // Test Containers
    testCompile("org.testcontainers:testcontainers:1.14.3")
    testImplementation("org.testcontainers:postgresql:1.14.3")
    testImplementation("org.testcontainers:junit-jupiter:1.14.3")
}

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "5.6.4"
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    mainClassName = "ru.hotel.management.booking.HotelManagementBookingApplication"
}

tasks.build {
    dependsOn(tasks.bootJar)
}

springBoot {
    mainClassName = "ru.hotel.management.booking.HotelManagementBookingApplication"
    buildInfo()
}

application {
    mainClassName = "ru.hotel.management.booking.HotelManagementBookingApplication"
}
