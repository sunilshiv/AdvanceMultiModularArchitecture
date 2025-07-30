import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.report.ReportMergeTask

val DETEKT_VERSION = "1.23.3"

apply<DetektPlugin>()

configure<DetektExtension> {
    toolVersion = DETEKT_VERSION
    source.from("src/main/java", "src/main/kotlin")

    config.from(file("${rootProject.projectDir}/detekt/detekt-config.yml"))
    baseline = file("${rootProject.projectDir}/detekt/detekt-baseline.xml")

    parallel = false
    buildUponDefaultConfig = false
    allRules = false
    disableDefaultRuleSets = false
    debug = true
    ignoreFailures = false

    ignoredBuildTypes = listOf("release")
    ignoredFlavors = listOf("huawei")
    ignoredVariants = listOf("googleRelease")
    basePath = projectDir.absolutePath
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = JavaVersion.VERSION_1_8.toString()

    include("**/*.kt", "**/*.kts")
    exclude(
        "**/build/**",
        "**/generated/**",
        "**/resources/**",
        "**/tmp/**",
        "**/*Test*/**"
    )

    reports {
        xml.required.set(true)
        xml.outputLocation.set(file("${rootProject.projectDir}/detekt/detekt-report.xml"))

        html.required.set(true)
        html.outputLocation.set(file("${rootProject.projectDir}/detekt/detekt-report.html"))

        sarif.required.set(true)
        sarif.outputLocation.set(file("${rootProject.projectDir}/detekt/detekt-report.sarif"))

        md.required.set(true)
        md.outputLocation.set(file("${rootProject.projectDir}/detekt/detekt-report.md"))

        txt.required.set(true)
        txt.outputLocation.set(file("${rootProject.projectDir}/detekt/detekt-report.txt"))
    }
}

// Add Detekt formatting plugin
dependencies {
    "detektPlugins"("io.gitlab.arturbosch.detekt:detekt-formatting:$DETEKT_VERSION")
}

// Report merge task
tasks.register<ReportMergeTask>("mergeDetektReports") {
    group = "reporting"
    description = "Merges all detekt reports into one report file."
    dependsOn("detekt")
}

// Hook tasks for CI or Gradle flow
tasks.named("detekt") {
    dependsOn("detektBaseline")
    dependsOn(":features:login:detektBaseline")
}

tasks.named("preBuild") {
    dependsOn("detekt")
}
