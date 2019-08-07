package com.example.mt.di.module

import android.content.Context
import com.example.mt.App
import com.example.mt.di.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 *Time:2019/8/7
 *Author:zyh
 *Description:
 */
@Module
class AppModule(val context: App) {
    @AppScope
    @Provides
    fun provideContext():Context{
        return this.context
    }
}