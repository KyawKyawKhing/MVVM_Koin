package com.kkk.mvvm_koin.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.kkk.mvvm_koin.data.NoticeSelectEvent
import com.kkk.mvvm_koin.data.NoticeUIModel
import com.kkk.mvvm_koin.network.DataRepository.NoticeRepository
import com.kkk.mvvm_koin.network.rx.SchedulerProvider
import com.kkk.mvvm_koin.utility.SingleLiveEvent

class MainViewModel(private val repository: NoticeRepository, private val schedulerProvider: SchedulerProvider) : BaseViewModel() {

    val uiData = MutableLiveData<NoticeUIModel>()
    val selectEvent = SingleLiveEvent<NoticeSelectEvent>()

    fun getNoticeList() {
        launch {
            repository.getNoticeList()
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.mainThread())
                    .subscribe({ noticeResponse ->
                        uiData.value = NoticeUIModel(list = noticeResponse.noticeList)
                    }, { error ->
                        uiData.value = NoticeUIModel(error = error)
                    })
        }
    }
}
