package com.example.clonenowinandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import com.example.clonenowinandroid.ui.NiaApp
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //window 를 fit 하게 하는지 설정하는 부분같다.

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            NiaApp(windowSizeClass = calculateWindowSizeClass(activity = this))
        }
    }
}
