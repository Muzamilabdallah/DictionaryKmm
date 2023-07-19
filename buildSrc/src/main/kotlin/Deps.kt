import Versions.activityComposeVersion
import Versions.composeVersion
import Versions.gradleVersion
import Versions.koin
import Versions.kotlinVersion
import Versions.ktorVersion
import Versions.sqlDelightGradleVersion
import Versions.sqlDelightVersion

object Deps {

    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    const val composeUi = "androidx.compose.ui:ui:$composeVersion"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val composeFoundation = "androidx.compose.foundation:foundation:$composeVersion"
    const val composeMaterial = "androidx.compose.material:material:$composeVersion"
    const val composeIconsExtended =
        "androidx.compose.material:material-icons-extended:$composeVersion"

    //ktor
    const val ktorCore = "io.ktor:ktor-client-core:$ktorVersion"
    const val ktorSerialization = "io.ktor:ktor-client-content-negotiation:$ktorVersion"
    const val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
    const val ktorAndroid = "io.ktor:ktor-client-android:$ktorVersion"
    const val ktorIOS = "io.ktor:ktor-client-ios:$ktorVersion"
    const val clientJson = "io.ktor:ktor-client-json:${ktorVersion}"
    const val clientLogging = "io.ktor:ktor-client-logging:${ktorVersion}"


    //gradle
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidBuildTools = "com.android.tools.build:gradle:$gradleVersion"
    const val sqlDelightGradlePlugin =
        "com.squareup.sqldelight:gradle-plugin:$sqlDelightGradleVersion"

    // SQLDELIGHT
    const val sqlDelightRuntime = "com.squareup.sqldelight:runtime:$sqlDelightVersion"
    const val sqlDelightAndroidDriver = "com.squareup.sqldelight:android-driver:$sqlDelightVersion"
    const val sqlDelightNativeDriver = "com.squareup.sqldelight:native-driver:$sqlDelightVersion"
    const val sqlDelightCoroutinesExtensions =
        "com.squareup.sqldelight:coroutines-extensions:$sqlDelightVersion"

    //koin
    const val koin = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"

    //kmmviewmodel
   const val kmmViewModel="com.rickclephas.kmm:kmm-viewmodel-core:${Versions.kmmViewModel}"
    const val NativeCoroutinesPlugin = "com.rickclephas.kmp:kmp-nativecoroutines-gradle-plugin"

}