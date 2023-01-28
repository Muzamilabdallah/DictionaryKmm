package com.muzamil.dictionarykmm.android.core

import android.app.Application
import com.muzamil.dictionarykmm.android.di.appModule
import com.muzamil.dictionarykmm.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent

class App : Application() , KoinComponent {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}