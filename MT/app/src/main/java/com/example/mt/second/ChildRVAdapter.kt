package com.example.mt.second

import android.content.Context
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mt.R
import kotlinx.android.synthetic.main.rv_child_item.view.*

/**
 *Time:2019/5/28
 *Author:zyh
 *Description:
 */
class ChildRVAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var context: Context? = null
    var str : String ? = null
    constructor(context: Context?,str : String) : this(){
        this.context = context
        this.str = str
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder = ViewHolder(LayoutInflater
            .from(context).inflate(R.layout.rv_child_item ,parent ,false)) //inflate 三个参数,设置布局宽高才管用

    override fun getItemCount(): Int =10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p: Int) {
        if (holder is ViewHolder){
            holder.run {
                tv.text = "Hi Kotlin,$str"
                iv.setImageResource(R.mipmap.ic_launcher_round)
                itemView.setOnClickListener {
                    Toast.makeText(context,"Hi Kotlin,$str,$p", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tv = itemView.child_tv
        val iv = itemView.child_iv
    }
}