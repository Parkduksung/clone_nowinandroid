plugins {
    id("clonenowinandroid.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}


dependencies {
    implementation(project(":core-common"))
    implementation(project(":core-model"))
    implementation(project(":core-network"))
    implementation(project(":core-datastore"))
    implementation(project(":core-network"))

    testImplementation(project(":core-testing"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}