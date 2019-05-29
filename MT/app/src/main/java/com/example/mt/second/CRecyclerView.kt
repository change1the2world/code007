package com.example.mt.second

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent

/**
 *Time:2019/5/29
 *Author:zyh
 *Description:
 */
class CRecyclerView : RecyclerView {
    constructor(context: Context):super(context)
    constructor(context: Context, attrs: AttributeSet?):super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int):super(context, attrs, defStyle)

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        //父层ViewGroup不要拦截点击事件
        parent.requestDisallowInterceptTouchEvent(false)
        return super.dispatchTouchEvent(ev)
    }
}