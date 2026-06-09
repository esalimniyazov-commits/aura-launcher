package com.example.auralauncher.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.auralauncher.model.AppInfo

@Composable
fun Dock(
    favorites: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(Color.White.copy(alpha = 0.15f))
            .padding(vertical = 8.dp)
    ) {
        favorites.take(4).forEach { app ->
            AppIcon(app = app, showLabel = false) { onAppClick(app) }
        }
    }
}
