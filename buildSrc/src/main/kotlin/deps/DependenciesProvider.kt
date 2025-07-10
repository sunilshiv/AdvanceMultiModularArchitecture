package deps

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import test.TestDependencies

fun DependencyHandler.room(){
    implementation(Dependencies.ROOM_RUNTIME)
    kapt(Dependencies.ROOM_COMPILER)
    implementation(Dependencies.ROOM_KTX)
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
   //implementation(platform(Dependencies.ANDROIDX_ACTIVITY_COMPOSE_BOM).toString())
}

fun DependencyHandler.loginModule() {
    moduleImplementation(project(":features:login"))
}

fun DependencyHandler.homeModule() {
    moduleImplementation(project(":features:home"))
}

fun DependencyHandler.testDeps(){
    testImplementation(TestDependencies.ANDROIDX_JUNIT_VERSION)
}

fun DependencyHandler.testImplDeps(){
    androidTestImplementation(TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(TestDependencies.ANDROIDX_COMPOSE_UI_TEST)
}

fun DependencyHandler.testDebugDeps(){
    debugImplementation(Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    debugImplementation(TestDependencies.ANDROIDX_COMPOSE_UI_TEST_MANIFEST)
}
