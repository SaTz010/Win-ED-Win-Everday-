package com.example.wined

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wined.navigation.AppNavigation
import com.example.wined.ui.theme.WinEDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WinEDTheme {
                AppNavigation()
            }
        }
    }
}
