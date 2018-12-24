package com.kkk.mvvm_koin.data

import com.kkk.mvvm_koin.network.NetworkResponse.Notice

data class NoticeUIModel(val list: List<Notice> = emptyList(), val error: Throwable? = null)
