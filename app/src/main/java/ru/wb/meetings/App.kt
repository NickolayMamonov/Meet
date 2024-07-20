package ru.wb.meetings

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.wb.meetings.di.appModule
import ru.wb.meetings.di.dataModule
import ru.wb.meetings.di.domainModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(appModule, dataModule, domainModule)
        }
    }
}