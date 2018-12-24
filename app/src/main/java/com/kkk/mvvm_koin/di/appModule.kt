package com.kkk.mvvm_koin.di

import com.kkk.mvvm_koin.network.DataRepository.NoticeRepository
import com.kkk.mvvm_koin.network.DataRepository.NoticeRepositoryImpl
import com.kkk.mvvm_koin.network.rx.AndroidSchedulerProvider
import com.kkk.mvvm_koin.network.rx.SchedulerProvider
import com.kkk.mvvm_koin.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val noticeModule = module(definition = {

    //provide data repository
    single<NoticeRepository> { NoticeRepositoryImpl(get()) }

//    ViewModel for Home
    viewModel { MainViewModel(get(), get()) }

})

val rxModule = module {
    //provide schedule provider
    factory<SchedulerProvider> { AndroidSchedulerProvider() }
}

val appModule = listOf(remoteDatasourceModule, rxModule, noticeModule)
