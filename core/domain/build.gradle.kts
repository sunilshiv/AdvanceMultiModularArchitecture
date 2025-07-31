import deps.testDebugDeps
import deps.testDeps
import deps.testImplDeps
import plugs.SharedLibraryGradlePlugins

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
}
apply<SharedLibraryGradlePlugins>()
android {
    namespace = "com.demo.domain"
}

dependencies {
    testDeps()
    testImplDeps()
    testDebugDeps()
}
