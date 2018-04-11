package com.tmdbcodlab.android

import android.app.Application
import android.support.multidex.MultiDex
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        MultiDex.install(this)

    }
}