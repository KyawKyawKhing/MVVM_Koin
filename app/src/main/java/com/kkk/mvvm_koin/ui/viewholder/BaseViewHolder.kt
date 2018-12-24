package com.kkk.mvvm_koin.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<in O>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun setData(data: O)
}