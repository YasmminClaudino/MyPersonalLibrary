package com.ymmc.mypersonallibrary

import android.app.Application
import android.util.Log
import com.ymmc.backend.di.NetworkModuleLoader
import com.ymmc.mypersonallibrary.di.AppModuleLoader
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyPersonalLibraryApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: Application created")
        loadModules()
    }

    private fun loadModules() {
        startKoin {
            androidLogger()
            androidContext(this@MyPersonalLibraryApp)
            val moduleLoaders = listOf(
                AppModuleLoader,
                NetworkModuleLoader
            )
            moduleLoaders.forEach{
                it.load()
            }
        }
    }

    companion object {
        private const val TAG = "MyPersonalLibraryApp"
    }

}