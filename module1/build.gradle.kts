group = rootProject.group
version = rootProject.version

@Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    id(libs.plugins.kotlin.jvm.get().pluginId)
    alias(libs.plugins.buildconfig) apply false
}

dependencies {
    implementation(gradleApi())
    implementation(project(":module2"))
    implementation(libs.junit.api)
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
    testRuntimeOnly(libs.junit.engine)
}

tasks.test {
    useJUnitPlatform() // ✅ Ensures JUnit 5 is used

    testLogging {
        events("passed", "skipped", "failed") // ✅ Logs test results in the console
    }
}