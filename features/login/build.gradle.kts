import deps.Dependencies
import deps.androidx
import deps.hilt
import deps.room
import deps.testDebugDeps
import deps.testDeps
import deps.testImplDeps
import plugs.SharedLibraryGradlePlugins

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
}
apply<SharedLibraryGradlePlugins>()
android {
    namespace = "com.example.login"
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
