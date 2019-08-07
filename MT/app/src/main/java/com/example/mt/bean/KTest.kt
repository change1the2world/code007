package com.example.mt.bean

import javax.inject.Inject

/**
 *Time:2019/8/6
 *Author:zyh
 *Description:
 */
class KTest {
    @Inject
    constructor()
    var name: String? = null
    var age : Int = 0

    override fun toString(): String {
        return "name = zyh,age = 18"
    }
}