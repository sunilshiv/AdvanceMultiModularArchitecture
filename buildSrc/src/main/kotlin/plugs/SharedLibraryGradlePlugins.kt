package plugs

import build.BuildConfig
import build.BuildDimensions
import com.android.build.gradle.LibraryExtension
import flavours.BuildFlavour
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import test.TestBuildConfig

class SharedLibraryGradlePlugins: Plugin<Project> {
    override fun apply(project: Project) {
        project.addPluginConfigurations()
        project.addAndroidConfigurations()
        project.applyKotlinConfigurations()
    }

    private fun Project.addPluginConfigurations(){
        plugins.apply(BuildPlugins.KOTLIN_ANDROID)
        plugins.apply(BuildPlugins.KAPT)
    }

    private fun Project.addAndroidConfigurations(){
        extensions.getByType(LibraryExtension::class.java).apply {
            compileSdk = BuildConfig.COMPILE_SDK_VERSION
            defaultConfig{
                minSdk = BuildConfig.MIN_SDK_VERSION
                testInstrumentationRunner = TestBuildConfig.TEST_INSTRUMENT_RUNNER
            }
            flavorDimensions.add(BuildDimensions.APP)
            flavorDimensions.add(BuildDimensions.STORE)

            productFlavors{
                BuildFlavour.Google.createLibrary(this)
                BuildFlavour.Huawei.createLibrary(this)
                BuildFlavour.Client.createLibrary(this)
                BuildFlavour.Driver.createLibrary(this)
            }
            compileOptions{
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }

            buildFeatures {
                compose = true
                buildConfig = true
            }
        }

    }

    private fun Project.applyKotlinConfigurations(){
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>{
            kotlinOptions{
                jvmTarget = JavaVersion.VERSION_11.toString()
            }
        }

    }
}