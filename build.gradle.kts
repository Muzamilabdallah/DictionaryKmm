plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.3.0").apply(false)
    id("com.android.library").version("7.3.0").apply(false)
    id("com.squareup.sqldelight").version("1.5.3").apply(false)
//    id(Deps.NativeCoroutinesPlugin).version("${Versions.kmpNativeCoroutinesVersion}").apply(false)
    kotlin("android").version("1.7.10").apply(false)
    kotlin("multiplatform").version("1.7.10").apply(false)
    kotlin("plugin.serialization").version("1.7.10")

}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
