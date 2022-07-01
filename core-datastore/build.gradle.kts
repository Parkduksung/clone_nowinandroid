import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("clonenowinandroid.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")

}

android {
    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }

}

dependencies {
    implementation(project(":core-common"))
    testImplementation(project(":core-testing"))

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.dataStore.core)
    implementation(libs.protobuf.kotlin.lite)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)
}