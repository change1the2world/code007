package com.example.mt.imp

import javax.inject.Inject

/**
 *Time:2019/8/7
 *Author:zyh
 *Description:
 */
class TestInterfaceImp2 @Inject constructor():TestInterface {
    override fun getTestInfo(): String = "我是TestInterface的第二个实现"
}