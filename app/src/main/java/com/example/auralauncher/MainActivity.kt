package com.example.auralauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.auralauncher.ui.HomeScreen
import com.example.auralauncher.ui.theme.AuraLauncherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuraLauncherTheme {
                HomeScreen()
            }
        }
    }
}
