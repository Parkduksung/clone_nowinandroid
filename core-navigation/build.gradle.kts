plugins {
    id("clonenowinandroid.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.ksp)
}

dependencies {
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}