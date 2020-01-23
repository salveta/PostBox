package com.salvaperez.postbox

import android.app.Application
import com.salvaperez.postbox.di.appModule
import com.salvaperez.postbox.di.dataModule
import com.salvaperez.postbox.di.postsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PostBoxApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PostBoxApp)
            modules(listOf(appModule, dataModule, postsModule))
        }
    }
}