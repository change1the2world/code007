package com.example.mt

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *Time:2019/5/15
 *Author:zyh
 *Description:
 */
object TMain {
    var arrs = arrayOf(arrayOf("张"), arrayOf("王"), arrayOf("李"), arrayOf("赵"))
    val num: Int = 1281
    val number : Int = num
    var result : Boolean = false
    var str : String = "zhangyaohua"
    @JvmStatic
    fun main(array: Array<String>) {
        for (i in 0 until arrs.size){
            print(arrs[i][0])
        }
        println()
        with(arrs){
            println("start")
            println("frist = ${first()[0][0]}")
            println("last = ${last()[0][0]}")
            println("end")
        }
        val apply = with(arrs) {
                    println("start")
                    println("frist = ${first()[0][0]}")
                    println("last = ${last()[0][0]}")
                }
        println("aaa $apply")
        result = num == number
        println(result)
        val map = str.map { it.toUpperCase() }
        println(map)

        main()

    }

    fun main() = runBlocking{ // 开始执行主协程
        val launch = GlobalScope.launch {
            delay(10000L)
            // 在后台启动一个新的协程并继续
            println("World!${Thread.currentThread().name}")
        }
        println("Hello,${Thread.currentThread().name}") // 主协程在这里会立即执行
        launch.join()
    }
}