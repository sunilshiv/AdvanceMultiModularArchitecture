import build.BuildConfig
import build.BuildCreator
import build.BuildDimensions
import deps.Dependencies
import deps.DependenciesVersions
import deps.androidx
import deps.hilt
import deps.loginModule
import deps.okhttp
import deps.retrofit
import deps.room
import deps.testDebugDeps
import deps.testDeps
import deps.testImplDeps
import flavours.BuildFlavour
import release.ReleaseConfig
import signing.BuildSigning
import signing.SigningTypes
import test.TestBuildConfig

plugins {
    id(plugs.BuildPlugins.ANDROID_APPLICATION)
    id(plugs.BuildPlugins.KOTLIN_ANDROID)
    id(plugs.BuildPlugins.ANDROID)
    id(plugs.BuildPlugins.KAPT)
    id(plugs.BuildPlugins.KTLINT)
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

    signingConfigs {
        BuildSigning.Release(project).create(this)
        BuildSigning.ReleaseQa(project).create(this)
        BuildSigning.Debug(project).create(this)
    }

    buildTypes {
        BuildCreator.Release(project).create(this).apply {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            signingConfig = signingConfigs.getByName(SigningTypes.RELEASE)
        }
        BuildCreator.ReleaseQa(project).create(this).apply {
            signingConfig = signingConfigs.getByName(SigningTypes.RELEASE_QA)
        }

        BuildCreator.Debug(project).create(this).apply {
            signingConfig = signingConfigs.getByName(SigningTypes.DEBUG)
        }
    }

    flavorDimensions.add(BuildDimensions.APP)
    flavorDimensions.add(BuildDimensions.STORE)

    productFlavors {
        BuildFlavour.Google.create(this)
        BuildFlavour.Huawei.create(this)
        BuildFlavour.Client.create(this)
        BuildFlavour.Driver.create(this)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = DependenciesVersions.KOTLIN_COMPILER
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    loginModule()
    androidx()
    implementation(platform(Dependencies.ANDROIDX_ACTIVITY_COMPOSE_BOM))
    room()
    annotationProcessor(Dependencies.ROOM_COMPILER)
    hilt()
    retrofit()
    okhttp()
    testDeps()
    testImplDeps()
    testDebugDeps()
}
