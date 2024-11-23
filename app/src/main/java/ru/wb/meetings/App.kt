package ru.wb.meetings

import android.app.Application
import dev.whysoezzy.data.di.dataModule
import dev.whysoezzy.domain.di.domainModule
import dev.whysoezzy.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            Timber.plant(Timber.DebugTree())
            modules(viewModelModule, domainModule, dataModule)
        }
    }
}