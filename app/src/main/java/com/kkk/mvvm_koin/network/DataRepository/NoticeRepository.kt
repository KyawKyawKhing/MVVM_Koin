package com.kkk.mvvm_koin.network.DataRepository

import com.kkk.mvvm_koin.network.NetworkResponse.NoticeListResponse
import io.reactivex.Observable

interface NoticeRepository {
    fun getNoticeList(): Observable<NoticeListResponse>
}