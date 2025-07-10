import deps.Dependencies
import deps.androidx
import deps.hilt
import deps.loginModule
import deps.okhttp
import deps.retrofit
import deps.room
import deps.testDebugDeps
import deps.testDeps
import deps.testImplDeps

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
    id(plugs.BuildPlugins.KOTLIN_ANDROID)
    kotlin(plugs.BuildPlugins.KAPT)
}

android {
    namespace = "com.example.login"

    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    androidx()
    implementation(platform(Dependencies.ANDROIDX_ACTIVITY_COMPOSE_BOM))
    room()
    hilt()
    testDeps()
    testImplDeps()
    testDebugDeps()
}