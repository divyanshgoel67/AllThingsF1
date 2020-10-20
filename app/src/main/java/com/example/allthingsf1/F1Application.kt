package com.example.allthingsf1

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.f1repository.RepositoryInitialiser
import com.facebook.stetho.Stetho

class F1Application : Application() {

    companion object {

        const val TAG = "F1Application"
        private lateinit var appContext: Context

        @JvmStatic
        fun getContext(): Context {
            return appContext
        }

    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "OnCreate")
        appContext = applicationContext

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }

        RepositoryInitialiser.initialise(appContext)

        // Initialise Repository manager and update static repository component
        RepositoryManager.initialise()
    }

}
