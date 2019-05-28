package com.example

import android.annotation.SuppressLint
import android.support.v4.app.FragmentActivity

import com.tbruyelle.rxpermissions2.Permission
import com.tbruyelle.rxpermissions2.RxPermissions

import io.reactivex.functions.Consumer

/**
 * Time:2019/5/27
 * Author:zyh
 * Description:
 */
class RxUtil private constructor(private val activity: FragmentActivity) {
    private var rxPermissions: RxPermissions? = null

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var rxUtil: RxUtil? = null
        @Synchronized
        fun getInstance(activity: FragmentActivity): RxUtil {
            if (rxUtil == null) {
                rxUtil = RxUtil(activity)
            }
            return rxUtil!!
        }
    }

    @SuppressLint("CheckResult")
    fun request(i: Int, listener: RxCompletedListener, vararg ags: String) {
        if (rxPermissions == null) {
            rxPermissions = RxPermissions(activity)

            when (i) {
                1 -> rxPermissions!!.requestEach(ags[0])
                        .subscribe { permission ->
                            when {
                                permission.granted -> listener.onAgree()
                                permission.shouldShowRequestPermissionRationale -> listener.onRefuse()
                                else -> listener.onAskNoMore()
                            }
                        }
                2 -> rxPermissions!!.requestEach(ags[0], ags[1])
                        .subscribe { permission ->
                            when {
                                permission.granted -> listener.onAgree()
                                permission.shouldShowRequestPermissionRationale -> listener.onRefuse()
                                else -> listener.onAskNoMore()
                            }
                        }
                3 -> rxPermissions!!.requestEach(ags[0], ags[1], ags[2])
                        .subscribe { permission ->
                            when {
                                permission.granted -> listener.onAgree()
                                permission.shouldShowRequestPermissionRationale -> listener.onRefuse()
                                else -> listener.onAskNoMore()
                            }
                        }
            }
        }
    }

    interface RxCompletedListener {
        fun onAgree()
        fun onRefuse()
        fun onAskNoMore()
    }


}
