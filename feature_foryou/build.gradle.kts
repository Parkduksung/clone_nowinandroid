plugins{
    id("clonenowinandroid.android.library")
    id("clonenowinandroid.android.library.compose")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    //테스트 추가해야함.
//    defaultConfig {
//        testInstrumentationRunner =
//            ""
//    }
}

dependencies {

    implementation(project(":core-ui"))
    implementation(project(":core-navigation"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)

    implementation(libs.accompanist.flowlayout)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
    configurations.configureEach {
        resolutionStrategy {
            force(libs.junit4)
            // Temporary workaround for https://issuetracker.google.com/174733673
            force("org.objenesis:objenesis:2.6")
        }
    }

}