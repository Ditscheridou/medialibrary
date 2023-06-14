plugins {
    id("java")
}

group = "de.jds"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.github.holgerbrandl:themoviedbapi:1.15")
    implementation("com.formdev:flatlaf:3.1.1")
}

tasks.test {
    useJUnitPlatform()
}