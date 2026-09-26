package com.guimor.tennisumpire

import android.content.Context
import java.io.File

fun onAppLaunch(context: Context) {
    val cacheDir = File(context.cacheDir, "camera_cache")
    cacheDir.listFiles()?.forEach { it.delete() }
}