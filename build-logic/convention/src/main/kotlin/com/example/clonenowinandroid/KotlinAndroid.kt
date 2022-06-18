package com.example.clonenowinandroid

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

//Project = org.gradle.api 꺼 그리고 인터페이스임.
//This interface is the main API you use to interact with Gradle from your build file
//아래 확장함수의 ExtensionAware 를 상속받고 있다.
//파라메터로 CommonExtension 받고
//거기에 공통적인 부분 추가하는거로 보여진다.
fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *>
) {

}



//BuildFeatures, BuildType, DefaultConfig, ProductFlavor 에 대한 옵션을 처리하는 거로 판단된다.
private fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}