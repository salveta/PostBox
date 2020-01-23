package com.salvaperez.postbox

import android.app.Application
import com.salvaperez.postbox.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PostBoxApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}