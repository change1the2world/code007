package com.example.mt.imp

import javax.inject.Inject

/**
 *Time:2019/8/7
 *Author:zyh
 *Description:
 */
class TestInterfaceImp @Inject constructor():TestInterface {
    override fun getTestInfo(): String = "我是TestInterface的第一个实现"
}