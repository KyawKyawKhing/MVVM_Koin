package com.kkk.mvvm_koin

import android.app.Application
import com.kkk.mvvm_koin.di.appModule
import org.koin.android.ext.android.startKoin

class NoticeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModule)
    }
}
