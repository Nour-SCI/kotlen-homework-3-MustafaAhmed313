plugins {
    id("org.jetbrains.kotlin.jvm")
}

group = rootProject.group
version = rootProject.version

dependencies {
    implementation(project(":module2"))
    implementation(libs.junit.api)
    testImplementation(libs.junit.params)
    testImplementation(libs.junit.console)
    testRuntimeOnly(libs.junit.engine)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform() // ✅ Ensures JUnit 5 is used
}