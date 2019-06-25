package com.example.mt.custom

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Message

/**
 *Time:2019/5/31
 *Author:zyh
 *Description:
 */
class HttpHelper private constructor(context: Context) :OnClickChangeListener{
    override fun add() {
        println("啊啊啊啊啊啊")
    }


    private lateinit var url: String
    private lateinit var tag: String
    private lateinit var map : HashMap<String,String>
    private var handler :Handler = @SuppressLint("HandlerLeak")
    object : Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    }

    companion object{
        @Volatile
        var httpHelper : HttpHelper? = null
        @Synchronized
        fun getInstance(context: Context) : HttpHelper{
            if (httpHelper == null){
                httpHelper = HttpHelper(context)
            }
            return httpHelper!!
        }
    }

    fun setUrl(url : String) : HttpHelper{
        this.url = url
        return this
    }
    fun setTag(tag : String) : HttpHelper{
        this.tag = tag
        return this
    }
    fun setParams(map : HashMap<String,String>) : HttpHelper{
        this.map = map
        return this
    }
    fun execute(){
        val run = object :Runnable {
            override fun run() {
                handler.postDelayed(this,100)
            }

        }
    }

    fun Any.toString():String{
        if (this == null) return "I'M is NUll"
        return toString()
    }
}