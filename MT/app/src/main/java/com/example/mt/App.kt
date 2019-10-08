package com.example.mt

import android.app.Application
import com.example.mt.di.commponent.*
import com.example.mt.di.module.ActivityModule
import com.example.mt.di.module.AppModule
import com.example.mt.di.module.TestModule

/**
 *Time:2019/5/15
 *Author:zyh
 *Description:
 */
class App : Application() {

    lateinit var appCommponent:AppCommponent
    companion object{
        var app : App? = null
    }
    override fun onCreate() {
        super.onCreate()
        app = this
        appCommponent = DaggerAppCommponent.builder().appModule(AppModule(this)).build()
    }

    fun getActivityCommponent():ActivityCommponent =
            DaggerActivityCommponent.builder()
                    .appCommponent(appCommponent)
                    .activityModule(ActivityModule()).build()

    fun getTestCommponent():TestCommponent =
            DaggerTestCommponent.builder()
                    .activityCommponent(getActivityCommponent())
                    .testModule(TestModule())
                    .build()
}