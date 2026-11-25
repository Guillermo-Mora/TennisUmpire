package com.guimor.tennisumpire.dependency_injection

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class MyApplication : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var appModule: AppModule
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this@MyApplication)
    }
}