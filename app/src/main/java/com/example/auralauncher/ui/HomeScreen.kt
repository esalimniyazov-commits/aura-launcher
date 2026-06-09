package com.example.auralauncher.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.auralauncher.data.AppRepository
import com.example.auralauncher.model.AppInfo
import com.example.auralauncher.ui.components.ClockWidget
import com.example.auralauncher.ui.components.Dock

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val repo = remember { AppRepository(context) }
    var apps by remember { mutableStateOf<List<AppInfo>>(emptyList()) }
    var drawerOpen by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { apps = repo.loadApps() }

    val auraGradient = Brush.verticalGradient(
        listOf(Color(0xFF1E1B4B), Color(0xFF4C1D95), Color(0xFF831843))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(auraGradient)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(80.dp))
            ClockWidget()
            Spacer(Modifier.weight(1f))
            Dock(favorites = apps, onAppClick = { repo.launchApp(it.packageName) })
            Spacer(Modifier.height(24.dp))
        }

        if (drawerOpen) {
            AppDrawer(
                apps = apps,
                onAppClick = { repo.launchApp(it.packageName) },
                onDismiss = { drawerOpen = false }
            )
        } else {
            androidx.compose.material3.TextButton(
                onClick = { drawerOpen = true },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 100.dp)
            ) {
                androidx.compose.material3.Text("⌃ Ilovalar", color = Color.White)
            }
        }
    }
}
