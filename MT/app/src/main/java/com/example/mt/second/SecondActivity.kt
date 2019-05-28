package com.example.mt.second

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.example.mt.R
import com.example.mt.bean.ResultInfo
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    var rvAdapter : SecondRVAdapter ? = null
    val list = mutableListOf<ResultInfo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = OrientationHelper.VERTICAL
        rvAdapter = SecondRVAdapter(this,list)
        rv.let {
            it.layoutManager = linearLayoutManager
            it.addItemDecoration(DividerItemDecoration(this,OrientationHelper.VERTICAL))
            it.itemAnimator = DefaultItemAnimator()
            it.adapter = rvAdapter
        }
        initData()
    }

    private fun initData() {
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——"))
        list.add(ResultInfo(1,"RV——1"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——2"))
        rvAdapter!!.notifyDataSetChanged()
    }

}
