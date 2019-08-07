package com.example.mt.di.commponent

import com.example.mt.di.module.ActivityModule
import com.example.mt.di.scope.ActivityScope
import dagger.Component

/**
 *Time:2019/8/7
 *Author:zyh
 *Description:
 */
@ActivityScope
@Component(dependencies = [AppCommponent::class],modules = [ActivityModule::class])
interface ActivityCommponent {
}