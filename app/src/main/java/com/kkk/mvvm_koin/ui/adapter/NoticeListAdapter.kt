package com.kkk.mvvm_koin.ui.adapter

import android.content.Context
import android.view.ViewGroup
import com.kkk.mvvm_koin.R
import com.kkk.mvvm_koin.network.NetworkResponse.Notice
import com.kkk.mvvm_koin.ui.viewholder.NoticeViewHolder

class NoticeListAdapter(context: Context, private val homeDelegate: String) :
        BaseRecyclerAdapter<NoticeViewHolder, Notice>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val view = mInflater.inflate(R.layout.list_item_notice, parent, false)
        return NoticeViewHolder(view, homeDelegate)
    }
}
