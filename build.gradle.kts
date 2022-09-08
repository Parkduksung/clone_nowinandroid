buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.hilt.gradlePlugin)
        classpath(libs.kotlin.serializationPlugin)
        classpath(libs.secrets.gradlePlugin)
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}