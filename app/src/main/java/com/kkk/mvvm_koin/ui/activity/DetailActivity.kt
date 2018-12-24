package com.kkk.mvvm_koin.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kkk.mvvm_koin.R
import com.kkk.mvvm_koin.network.NetworkResponse.Notice

class DetailActivity : AppCompatActivity() {
    companion object {
        private val IE_NOTICE = "IE_NOTICE"
        fun newIntent(context: Context, notice: Notice): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            val bd = Bundle()
            bd.putParcelable(IE_NOTICE, notice)
            intent.putExtras(bd)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
