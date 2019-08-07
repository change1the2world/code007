package com.example.mt.di.commponent

import android.content.Context
import com.example.mt.di.module.AppModule
import com.example.mt.di.scope.AppScope
import dagger.Component

/**
 *Time:2019/8/7
 *Author:zyh
 *Description:
 */
@AppScope
@Component(modules = [AppModule::class])
interface AppCommponent {
    fun context():Context
}