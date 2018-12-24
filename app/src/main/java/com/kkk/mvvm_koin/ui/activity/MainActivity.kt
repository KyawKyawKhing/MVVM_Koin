package com.kkk.mvvm_koin.ui.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.kkk.mvvm_koin.R
import com.kkk.mvvm_koin.data.NoticeUIModel
import com.kkk.mvvm_koin.ui.adapter.NoticeListAdapter
import com.kkk.mvvm_koin.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: NoticeListAdapter
    private val mViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter = NoticeListAdapter(this, "")
        rvNotice.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 1)
        }
        mViewModel.getNoticeList()
        mViewModel.uiData.observe(this, Observer<NoticeUIModel> {
            mAdapter.setNewList(it!!.list)
        })
    }
}
