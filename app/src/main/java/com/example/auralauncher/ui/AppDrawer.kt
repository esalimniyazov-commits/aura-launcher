package com.example.auralauncher.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.auralauncher.model.AppInfo
import com.example.auralauncher.ui.components.AppIcon

@Composable
fun AppDrawer(
    apps: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.55f))
    ) {
        Column(
            modifier = Modifier
                .align(androidx.compose.ui.Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(Color(0xFF15131F))
                .padding(16.dp)
        ) {
            androidx.compose.material3.Text(
                "Barcha ilovalar",
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
            LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                items(apps) { app ->
                    AppIcon(app = app) {
                        onAppClick(app)
                        onDismiss()
                    }
                }
            }
        }
    }
}
