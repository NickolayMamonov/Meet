package ru.wb.meetings

import android.app.Application
import dev.whysoezzy.data.di.repositoryModule
import dev.whysoezzy.domain.di.usecasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.wb.meetings.di.viewModelModule


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(viewModelModule, repositoryModule, usecasesModule)
        }
    }
}