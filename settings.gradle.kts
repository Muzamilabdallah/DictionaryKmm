pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }

}



rootProject.name = "DictionaryKmm"
include(":androidApp")
include(":shared")