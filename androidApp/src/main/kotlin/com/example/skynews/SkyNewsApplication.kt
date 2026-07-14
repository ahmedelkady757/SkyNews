package com.example.skynews

import android.app.Application
import com.example.skynews.data.local.appContext
import com.example.skynews.di.initKoin
import org.koin.android.ext.koin.androidContext

class SkyNewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        appContext = this
        
        initKoin {
            androidContext(this@SkyNewsApplication)
        }
    }
}
