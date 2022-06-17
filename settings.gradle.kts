
pluginManagement {
    includeBuild("build-logic") // 여기를 지정해줘야 디렉터리가 파란색으로 변함.
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}


rootProject.name = "CloneNowInAndroid"
include(":app")