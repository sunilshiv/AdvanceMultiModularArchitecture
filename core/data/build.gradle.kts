import deps.hilt
import deps.okhttp
import deps.retrofit
import deps.testDebugDeps
import deps.testDeps
import deps.testImplDeps
import plugs.SharedLibraryGradlePlugins

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
}
apply<SharedLibraryGradlePlugins>()
android {
    namespace = "com.demo.data"
}

dependencies {
    okhttp()
    retrofit()
    hilt()
    testDeps()
    testImplDeps()
    testDebugDeps()
}
