package com.example.auralauncher.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val AuraAccent = Color(0xFF8B5CF6)
val AuraAccent2 = Color(0xFFEC4899)

private val DarkColors = darkColorScheme(
    primary = AuraAccent,
    secondary = AuraAccent2,
    background = Color(0xFF0B0B12)
)

private val LightColors = lightColorScheme(
    primary = AuraAccent,
    secondary = AuraAccent2,
    background = Color(0xFFF5F3FF)
)

@Composable
fun AuraLauncherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}
