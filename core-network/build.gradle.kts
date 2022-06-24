plugins {
    id("clonenowinandroid.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    buildTypes {
        val staging by creating {
            initWith(getByName("debug"))
            matchingFallbacks.add("debug")
        }
    }

}

dependencies {
    implementation(project(":core-common"))
    testImplementation(project(":core-testing"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}