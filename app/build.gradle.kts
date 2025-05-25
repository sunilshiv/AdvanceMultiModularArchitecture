plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
   // alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = BuildConfig.APP_ID
    compileSdk = BuildConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = BuildConfig.APP_ID
        minSdk = BuildConfig.MIN_SDK_VERSION
        targetSdk = BuildConfig.TARGET_SDK_VERSION
        versionCode = ReleaseConfig.VERSION_CODE
        versionName = ReleaseConfig.VERSION_NAME

        testInstrumentationRunner = TestBuildConfig.TEST_INSTRUMENT_RUNNER
    }

    buildTypes {
        getByName(BuildTypes.RELEASE){
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isMinifyEnabled = Build.Release.isMinifyEnabled
            isDebuggable = Build.Release.isDebuggable
            enableUnitTestCoverage = Build.Release.enableUnitTestCoverage
        }
        getByName(BuildTypes.DEBUG) {
            isMinifyEnabled = Build.Debug.isMinifyEnabled
            isDebuggable = Build.Debug.isDebuggable
            enableUnitTestCoverage = Build.Debug.enableUnitTestCoverage
            versionNameSuffix = Build.Debug.versionNameSuffix
            applicationIdSuffix = Build.Debug.applicationIdSuffix
        }
        create(BuildTypes.RELEASE_QA) {
            isMinifyEnabled = Build.ReleaseExternalQa.isMinifyEnabled
            isDebuggable = Build.ReleaseExternalQa.isDebuggable
            enableUnitTestCoverage = Build.ReleaseExternalQa.enableUnitTestCoverage
            versionNameSuffix = Build.ReleaseExternalQa.versionNameSuffix
            applicationIdSuffix = Build.ReleaseExternalQa.applicationIdSuffix
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.ANDROIDX_CORE)
    implementation(Dependencies.ANDROIDX_APP_COMPACT)
    implementation(Dependencies.ANDROIDX_MATERIAL3)
    implementation(Dependencies.ANDROIDX_ACTIVITY_COMPOSE)
    implementation(Dependencies.ANDROIDX_UI)
    implementation(Dependencies.ANDROIDX_UI_GRAPHICS)
    implementation(Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    //implementation(libs.material)
    implementation(Dependencies.ANDROIDX_ACTIVITY)
    implementation(Dependencies.ANDROIDX_CONSTRAINTLAYOUT)

    //Test dependencies
    testImplementation(TestDependencies.ANDROIDX_JUNIT_VERSION)
    androidTestImplementation(TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(TestDependencies.ANDROIDX_COMPOSE_UI_TEST)

    //Debug dependencies
    debugImplementation(Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    debugImplementation(TestDependencies.ANDROIDX_COMPOSE_UI_TEST_MANIFEST)
}