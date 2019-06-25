package com.example.mt.second

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import android.view.View
import com.example.mt.R
import com.example.mt.bean.ResultInfo
import com.example.mt.custom.HttpHelper
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    var t : String ? = null
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

        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (toolbar.height - appBar.height == verticalOffset) {
                toolbar_tv.visibility = View.VISIBLE
                //折叠监听
//                Toast.makeText(this@SecondActivity,"折叠了",Toast.LENGTH_SHORT).show()
            }else{
                toolbar_tv.visibility = View.INVISIBLE
            }
        })
        HttpHelper.getInstance(this).toString()

        Log.e("Main","我是3.0新加的")
        t.toString()
    }

    private fun initData() {
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——"))
        list.add(ResultInfo(1,"RV——1"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(1,"RV——1"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(1,"RV——1"))
        list.add(ResultInfo(2,"RV——2"))
        list.add(ResultInfo(2,"RV——2"))
        rvAdapter!!.notifyDataSetChanged()
    }

}
