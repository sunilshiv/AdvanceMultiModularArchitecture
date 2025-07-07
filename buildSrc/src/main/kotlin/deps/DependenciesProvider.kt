package deps

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.room(){
    implementation(Dependencies.ROOM_RUNTIME)
    implementation(Dependencies.ROOM_COMPILER)
    kapt(Dependencies.ROOM_KTX)
}

fun DependencyHandler.retrofit(){
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_COROUTINES_ADAPTER_VERSION)
    implementation(Dependencies.RETROFIT_CONVERTER_GSON)
}

fun DependencyHandler.okhttp(){
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.OKHTTP_LOGGING_INTERCEPTOR)
}

fun DependencyHandler.hilt(){
    implementation(Dependencies.HILT_ANDROID)
    kapt(Dependencies.HILT_COMPILER)
}

fun DependencyHandler.androidx(){
    implementation(Dependencies.ANDROIDX_CORE)
    implementation(Dependencies.ANDROIDX_ACTIVITY_COMPOSE)
    implementation(Dependencies.ANDROIDX_UI)
    implementation(Dependencies.ANDROIDX_UI_GRAPHICS)
    implementation(Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    implementation(Dependencies.ANDROIDX_ACTIVITY)
    implementation(Dependencies.ANDROIDX_CONSTRAINTLAYOUT)
    implementation(Dependencies.ANDROIDX_MATERIAL3)
    implementation(Dependencies.ANDROIDX_LIFECYCLE_RUNTIME_KTX)
    implementation(Dependencies.ANDROIDX_ACTIVITY_COMPOSE_BOM)
}

fun DependencyHandler.loginModule() {
    moduleImplementation(project(":features:login"))
}

fun DependencyHandler.homeModule() {
    moduleImplementation(project(":features:home"))
}