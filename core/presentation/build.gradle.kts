import deps.testDebugDeps
import deps.testDeps
import deps.testImplDeps
import plugs.SharedLibraryGradlePlugins

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
}
apply<SharedLibraryGradlePlugins>()
android {
    namespace = "com.demo.presentation"
}

dependencies {
    testDeps()
    testImplDeps()
    testDebugDeps()
}
