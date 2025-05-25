plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    api(kotlin("gradle-plugin:1.9.22"))
    implementation("com.android.tools.build:gradle:8.7.2")
}