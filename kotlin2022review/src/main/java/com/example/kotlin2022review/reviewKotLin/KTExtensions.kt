package com.example.kotlin2022review.reviewKotLin

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.reflect.Array.get
import kotlin.collections.ArrayList

//kotlin 扩展函数 extensions
fun main()
{
    Jump().test()
    val doubleJump = Jump().doubleJump()       //调用了扩展函数
    println(doubleJump)


    //调用泛型的扩展方法
    val mutableList:MutableList<Int> = mutableListOf<Int>(1, 2, 3, 4)
    mutableList.swap(0,3)
    println(mutableList.toString())

    //调用扩展属性
    val str="adjbkdjoiafj;ioaqjroiwak"
    val lastChar = str.lastChar
    println("----lastChar: $lastChar")

    //调用伴生对象的扩展
    Jump2.print("伴生对象添加的扩展---")

    //测试kotlin 源码中的扩展 let, run, apply
    testLet(null)
    testLet("test2")

    val testRun = testRun(Jump())
    println(testRun)

    testApply()


}

//----------下面定义类及其扩展函数---------------------------
class Jump
{
    fun test(){}
}

//扩展方法的定义，就是方法的前面加上 类名。
fun Jump.doubleJump():String
{
    return "doubleJump"
}

fun <T>MutableList<T>.swap(index1:Int,index2:Int)
{
    val temp = this[index1]
    this[index1]=this[index2]
    this[index2]=temp
}


//--------扩展属性---------
val String.lastChar:Char get()=this.get(this.length-1)

//---为伴生对象添加的扩展---
class Jump2
{
    companion object{}
}

fun Jump2.Companion.print(str:String)
{
    println(str)
}  // 主函数中可以调用 Jump2.print("伴生对象添加的扩展---")

//kotlin 源码中的扩展 let, run, apply
//let---
fun testLet(str:String?)
{
    str.let {
        val str2 = "let 扩展-无判空"
        println(it+str2)
    }
   // println(str2)  //错误，str2的作用域只在上面

    //判空用法，str 为空，不触发闭包里面的逻辑    ？。
    str?.let {
        //此时隐式函数it 不为空
        val str2 = "let 扩展-有判空"
        println(it+str2)
    }
    //用下面的，不用上面
}

//run---
fun testRun(jump: Jump):String
{
    jump.run {
        //jump.test()
        test()
        println("dddddd--test Run 扩展")
        return "kkkktest Run 扩展 返回"      //后两句是测试返回值的
    }
}

//apply---返回传入对象的本身
//----------------------------
//val arrayList = mutableListOf<String>()


fun testApply(){
     ArrayList<String>().apply {
         add("testApply")
         add("123")
         add("akakakak")
     }.run{
         println(this.toString()) }

    }





