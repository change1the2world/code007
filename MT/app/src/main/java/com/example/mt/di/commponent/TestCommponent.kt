package com.example.mt.di.commponent

import com.example.mt.MainActivity
import com.example.mt.di.module.TestModule
import com.example.mt.di.scope.TestScope
import com.example.mt.second.SecondActivity
import dagger.Component

/**
 *Time:2019/8/6
 *Author:zyh
 *Description:
 */
@TestScope
@Component(dependencies = [ActivityCommponent::class],modules = [TestModule::class])
interface TestCommponent {
    fun inject(mainActivity: MainActivity)
    fun inject(secondActivity: SecondActivity)
}