package com.example.mt.second

import android.app.Activity
import android.content.Context
import android.support.v7.widget.*
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.mt.R
import com.example.mt.bean.ResultInfo
import kotlinx.android.synthetic.main.rv_item_1.view.*
import kotlinx.android.synthetic.main.rv_item_2.view.*

/**
 *Time:2019/5/28
 *Author:zyh
 *Description:
 */
class SecondRVAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_ONE : Int = 1
    val TYPE_TWO : Int = 2
    private var context : Context ?= null
    private var list: MutableList<ResultInfo> ?= null
    constructor(context : Context,list: MutableList<ResultInfo>):this(){
        this.context = context
        this.list = list
    }
    override fun onCreateViewHolder(parent: ViewGroup, p: Int): RecyclerView.ViewHolder = when(p){
        1 ->
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_1, null))
        else ->
            ViewHolder1(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_2, null))
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p: Int) {
        if (holder is ViewHolder){
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = OrientationHelper.HORIZONTAL
            holder.rv?.let {
                it.layoutManager = linearLayoutManager
                it.addItemDecoration(DividerItemDecoration(context,OrientationHelper.VERTICAL))
                it.itemAnimator = DefaultItemAnimator()
                it.adapter = ChildRVAdapter(context,list!![p].name)
            }

        }else if (holder is ViewHolder1){
            holder.tv.text = "Hi kotlin,${list!![p].name}"
            holder.itemView.setOnClickListener {
                Toast.makeText(context,"${list!![p].name},$p",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun getItemCount(): Int = list!!.size

    override fun getItemViewType(position: Int): Int {
        if (list!![position].type == 1){
            return TYPE_ONE
        }else if (list!![position].type == 2){
            return TYPE_TWO
        }
        return 0
    }


    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val rv = itemView.rv_child
    }
    class ViewHolder1(itemView:View) : RecyclerView.ViewHolder(itemView){
        val tv = itemView.tv
    }

}