plugins {
    id("clonenowinandroid.android.library")
    alias(libs.plugins.ksp)
    id("kotlinx-serialization")
}

dependencies {
    testImplementation(project(":core-testing"))

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}