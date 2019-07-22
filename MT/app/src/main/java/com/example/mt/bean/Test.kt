package com.example.mt.bean

/**
 *Time:2019/6/25
 *Author:zyh
 *Description:
 */
object Test{
    @JvmStatic
    fun main(array: Array<String>){
//        print("" +
//                "   　　　　　／|          へ\n" +
//                "        　　/＼7　　　 ∠＿/\n" +
//                "        　 /　│　　 ／　／\n" +
//                "        　│　Z ＿, ＜　／　　 /`ヽ\n" +
//                "        　│　　　　　ヽ　　 /　　〉l\n" +
//                "        　 Y　　　　　`　 /　　/\n" +
//                "        　ｲ●　､　●　　⊂⊃〈　　/\n" +
//                "        　()　 へ　　　　|　＼〈\n" +
//                "        　　>ｰ ､_　 ィ　 │ ／／\n" +
//                "        　 / へ　　 /　ﾉ＜| ＼＼\n" +
//                "        　 ヽ_ﾉ　　(_／　 │／／\n" +
//                "        　　7　　　　　　　|／\n" +
//                "        　　＞―r￣￣`ｰ―＿")


        println(Box(1).values)
        println(Box("one").values)


        println(boxIn(2).values)
        println(boxIn("two").values)


        var runoob = Runoob("sting")
        var runoob1: Runoob<Any>
        runoob1 = runoob
        println(runoob1.toString())
    }

    private fun <T> boxIn(t:T) = Box(t)

    class  Box<T>(t:T){
        var values = t
    }

    // 定义一个支持逆变的类
    class Runoob<out A>(a: A) {

        fun foo() {

        }
    }
}