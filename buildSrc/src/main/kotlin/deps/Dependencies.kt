package deps

object Dependencies {


    const val ANDROIDX_CORE = "androidx.core:core-ktx:${DependenciesVersions.CORE_KTX}"
    const val ANDROIDX_LIFECYCLE_RUNTIME_KTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:${DependenciesVersions.LIFE_CYCLE_RUNTIME_KTX}"
    const val ANDROIDX_ACTIVITY_COMPOSE =
        "androidx.activity:activity-compose:${DependenciesVersions.ACTIVITY_COMPOSE}"
    const val ANDROIDX_UI = "androidx.compose.ui:ui:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_UI_GRAPHICS =
        "androidx.compose.ui:ui-graphics:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_UI_TOOLING_PREVIEW =
        "androidx.compose.ui:ui-tooling-preview:${DependenciesVersions.COMPOSE_UI}"

    //  const val ANDROIDX_MATERIAL= "com.google.android.material:material:${deps.DependenciesVersions.MATERIAL_3}"
    const val ANDROIDX_APP_COMPACT =
        "androidx.appcompat:appcompat:${DependenciesVersions.APP_COMPACT_VERSION}"
    const val ANDROIDX_ACTIVITY_COMPOSE_BOM =
        "androidx.compose:compose-bom:${DependenciesVersions.ACTIVITY_COMPOSE_BOM}"
    const val ANDROIDX_ACTIVITY =
        "androidx.activity:activity:${DependenciesVersions.ACTIVITY_COMPOSE}"
    const val ANDROIDX_CONSTRAINTLAYOUT =
        "androidx.constraintlayout:constraintlayout:${DependenciesVersions.ACTIVITY_CONSTRAINTLAYOUT}"
    const val ANDROIDX_MATERIAL3 =
        "androidx.compose.material3:material3:${DependenciesVersions.Android_MATERIAL_3}"

    const val HILT_ANDROID = "com.google.dagger:hilt-android:${DependenciesVersions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${DependenciesVersions.HILT}"
    const val HILT_AGP = "com.google.dagger:hilt-android-gradle-plugin:${DependenciesVersions.HILT}"
    const val hiltCompose = "androidx.hilt:hilt-work:${DependenciesVersions.HILT_COMPOSE}"
    const val hiltCompilerKapt = "androidx.hilt:hilt-compiler:${DependenciesVersions.HILT_COMPOSE}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${DependenciesVersions.HILT_COMPOSE}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${DependenciesVersions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON =
        "com.squareup.retrofit2:converter-gson:${DependenciesVersions.RETROFIT}"
    const val RETROFIT_COROUTINES_ADAPTER_VERSION =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${DependenciesVersions.RETROFIT_COROUTINE_ADAPTER_VERSION}"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${DependenciesVersions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${DependenciesVersions.OKHTTP}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${DependenciesVersions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${DependenciesVersions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${DependenciesVersions.ROOM}"

}
