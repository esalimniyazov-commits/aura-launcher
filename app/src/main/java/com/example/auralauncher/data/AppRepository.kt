package com.example.auralauncher.data

import android.content.Context
import android.content.Intent
import com.example.auralauncher.model.AppInfo

class AppRepository(private val context: Context) {

    fun loadApps(): List<AppInfo> {
        val pm = context.packageManager
        val intent = Intent(Intent.ACTION_MAIN, null).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }
        return pm.queryIntentActivities(intent, 0)
            .map { ri ->
                AppInfo(
                    label = ri.loadLabel(pm).toString(),
                    packageName = ri.activityInfo.packageName,
                    icon = ri.loadIcon(pm)
                )
            }
            .filter { it.packageName != context.packageName }
            .sortedBy { it.label.lowercase() }
    }

    fun launchApp(packageName: String) {
        val launch = context.packageManager.getLaunchIntentForPackage(packageName)
        launch?.let {
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(it)
        }
    }
}
