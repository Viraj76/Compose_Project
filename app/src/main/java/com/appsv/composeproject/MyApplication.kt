package com.appsv.composeproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dataModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module


class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                dataModules
            )
            androidContext(this@MyApplication)
        }
    }
}