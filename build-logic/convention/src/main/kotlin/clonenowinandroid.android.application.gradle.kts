import com.example.clonenowinandroid.configureKotlinAndroid

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    configureKotlinAndroid(this)

    defaultConfig {
        targetSdk = 32
    }

}