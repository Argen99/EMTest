package com.example.emtest

import android.app.Application
import com.example.account_presentation.di.accountModule
import com.example.data.di.dataModule
import com.example.favorites_presentation.di.favoritesModule
import com.example.main_presentation.di.mainModule
import com.example.presentation.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                authModule,
                mainModule,
                favoritesModule,
                accountModule,
                dataModule
            )
        }
    }
}