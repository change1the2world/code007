package com.example.mt



/**
 *Time:2019/5/15
 *Author:zyh
 *Description:
 */
object TMain {
    var arrs = arrayOf(arrayOf("张"), arrayOf("王"), arrayOf("李"), arrayOf("赵"))
    val number: Int = 1281
    var result: Boolean = false
    var str: String = "zhangyaohua"
    val str1 by lazy {
        //用到时候初始化
        println("time= ${System.currentTimeMillis()}")
        "ZHANG"
    }
    val arr by lazy {
        arrayOf("华", "耀", "张")
    }

    @JvmStatic
    fun main(array: Array<String>) {
        println("Main = ${System.currentTimeMillis()}")
        for (i in 0 until arrs.size) {
            print(arrs[i][0])
        }
        println()
        arrs.apply {
            println("start")
            println("frist = ${first()[0][0]}")
            println("last = ${last()[0][0]}")
            println("end")
        }
        val with = with(arrs) {
            println("start")
            println("frist = ${first()[0][0]}")
            println("last = ${last()[0][0]}")
            1
        }
        println("aaa $with")

        val map = str.map { it.toUpperCase() }
        println(map)

//        main()
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits.filter { it.startsWith("b") }
                .map { it.toUpperCase() }
                .forEach { println(it) }

        val mapOf = mapOf(0 to "张", 1 to "耀") //只读
        val mutableMapOf = mutableMapOf(0 to "张", 1 to "耀")
        println(mutableMapOf)
        mutableMapOf[2] = "华"
        println(mutableMapOf)

        val emails = listOf<String>() // 可能会是空集合
        val mainEmail = emails.firstOrNull() ?: "hi"
        println(mainEmail)

        val also = arrs.also {
            println("start")
            println("frist = ${it.first()[0][0]}")
            println("last = ${it.last()[0][0]}")
            println("end")
        }
        println("also${also.size}")
        println("${str1}str1 = ${System.currentTimeMillis()}")
//        main()

        print("" +
                " へ 　　　　　／|\n" +
                "        　　/＼7　　　 ∠＿/\n" +
                "        　 /　│　　 ／　／\n" +
                "        　│　Z ＿, ＜　／　　 /`ヽ\n" +
                "        　│　　　　　ヽ　　 /　　〉l\n" +
                "        　 Y　　　　　`　 /　　/\n" +
                "        　ｲ●　､　●　　⊂⊃〈　　/\n" +
                "        　()　 へ　　　　|　＼〈\n" +
                "        　　>ｰ ､_　 ィ　 │ ／／\n" +
                "        　 / へ　　 /　ﾉ＜| ＼＼\n" +
                "        　 ヽ_ﾉ　　(_／　 │／／\n" +
                "        　　7　　　　　　　|／\n" +
                "        　　＞―r￣￣`ｰ―＿")

    }

}