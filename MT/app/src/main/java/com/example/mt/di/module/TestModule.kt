package com.example.mt.di.module

import com.example.mt.di.scope.TestScope
import com.example.mt.imp.TestInterface
import com.example.mt.imp.TestInterfaceImp
import com.example.mt.imp.TestInterfaceImp2
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 *Time:2019/8/7
 *Author:zyh
 *Description:
 */
@Module
class TestModule {

    //    @TestScope
    @Named("first")
    @Provides
    fun provideTestInterface(testInterfaceImp: TestInterfaceImp): TestInterface {
        return testInterfaceImp
    }

    @Named("second")
    @Provides
    fun provideTestInterface2(testInterfaceImp: TestInterfaceImp2): TestInterface {
        return testInterfaceImp
    }
}