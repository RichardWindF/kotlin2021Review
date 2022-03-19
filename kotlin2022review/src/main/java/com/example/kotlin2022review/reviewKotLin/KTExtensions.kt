package com.example.kotlin2022review.reviewKotLin

import java.lang.reflect.Array.get

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
