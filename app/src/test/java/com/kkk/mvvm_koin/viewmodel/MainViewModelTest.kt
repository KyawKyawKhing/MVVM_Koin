package com.kkk.mvvm_koin.viewmodel

import android.arch.lifecycle.Observer
import com.kkk.mvvm_koin.data.NoticeUIModel
import com.kkk.mvvm_koin.di.testAppModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest : KoinTest {
    private val viewModel: MainViewModel by inject()

    @Mock
    private lateinit var listObserver: Observer<NoticeUIModel>

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        startKoin(testAppModule)
    }


    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun getNoticeList() {
        viewModel.uiData.observeForever(listObserver)
        viewModel.getNoticeList()

        val value = viewModel.uiData.value ?: error("No value for view myModel")

        Mockito.verify(listObserver).onChanged(NoticeUIModel(value.list))
    }
}