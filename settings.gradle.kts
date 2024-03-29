pluginManagement {
    includeBuild("build-logic") // 여기를 지정해줘야 디렉터리가 파란색으로 변함.
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {

        maven(url = "https://androidx.dev/snapshots/builds/8455591/artifacts/repository") {
            content {
                // The AndroidX snapshot repository will only have androidx artifacts, don't
                // bother trying to find other ones
                includeGroupByRegex("androidx\\..*")
            }
        }
        google()
        mavenCentral()
    }
}


rootProject.name = "CloneNowInAndroid"
include(":app")
include(":core:core-common")
include(":core-testing")
include(":core-data")
include(":core-network")
include(":core-model")
include(":core-datastore")
include(":core-ui")
include(":test")
include(":core-navigation")
include(":feature_foryou")
include(":feature-interests")
include(":core-database")
