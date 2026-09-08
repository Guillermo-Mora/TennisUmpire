package com.guimor.tennisumpire.dependency_injection

import android.app.Application

class MyApplication : Application() {
    lateinit var appModule: AppModule
        private set

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this@MyApplication)
    }
}