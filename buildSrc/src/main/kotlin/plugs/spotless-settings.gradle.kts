import com.diffplug.gradle.spotless.SpotlessPlugin

apply<SpotlessPlugin>()

configure<com.diffplug.gradle.spotless.SpotlessExtension> {


//    format("xml") {
//        target("**/*.xml")
//
//        prettier(
//            mapOf(
//                "prettier" to "3.2.5",
//                "@prettier/plugin-xml" to "3.1.0"
//            )
//        ).config(
//            mapOf(
//                "parser" to "xml",
//                "tabWidth" to 4,
//                "printWidth" to 80,
//                "useTabs" to false,
//                "semi" to true,
//                "singleQuote" to false,
//                "attributeSortOrder" to listOf("name", "id", "type"),
//                "selfClosingTags" to listOf("br", "img")
//            )
//        )
//
//        // Removed: indentWithSpaces(4)
//        trimTrailingWhitespace()
//        endWithNewline()
//    }



    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**", "**/buildSrc/**", "**/.*")
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
        ktlint("1.2.1")
            .editorConfigOverride(
                mapOf(
                    "indent_size" to "2",
                    "max_line_length" to "120",
                    "android" to "true"
                )
            )
    }

    java {
        target("**/*.java")
        targetExclude("**/build/**", "**/buildSrc/**", "**/.*")
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
        googleJavaFormat()
    }

    kotlinGradle {
        target("**/*.gradle.kts", "*.gradle.kts")
        targetExclude("**/build/**")
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
        ktlint("1.2.1")
            .editorConfigOverride(
                mapOf(
                    "indent_size" to "2",
                    "max_line_length" to "120",
                    "android" to "true"
                )
            )
    }
}

// ✅ Merge both dependencies in a single preBuild block
tasks.named("preBuild") {
    dependsOn("spotlessCheck", "spotlessApply")
}
