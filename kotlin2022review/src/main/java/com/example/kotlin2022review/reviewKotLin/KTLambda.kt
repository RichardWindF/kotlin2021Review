package com.example.kotlin2022review.reviewKotLin

import java.util.*

/**
 *
 * Mar-8-2022
 *
 * Kotlin 的方法，类，Lambda 表达式
 *
 */

fun main()
{
    //普通类成员方法， 要先构建实例对象，才能访问，但无 new 关键字--kotlin
    Person().test()      //java 中  new Person().test()

    //静态类的成员方法引用  类名。方法
    NumUtils.double(16)

    //伴生对象companion object 中的方法的引用
    Person().test()       // 普通方法的引用
    Person.test2()        //伴生方法引用同静态方法的引用
    println("-----------------------------")
    Person.test2() //伴生方法引用同静态方法的引用

    //-----------------------------------------------------
    //函数的参数问题
    //默认参数
    read(3,5)

    //具名参数
    read(start=15)

    read(offset = 2, start=5,action= { println("居民参数。。hello")})
    read(offset=2,start=5) { println("居民参数。。hello")}
    read(start=5){println("居民参数。。Hello")}  //此句  使用默认值 offset=1
    read(start=2, action = {println("居民参数。。hello")})

    //可变数量的参数 的函数调用
    println("----------------------------------------------")
    append('h', 'e', 'l', 'l', 'o','6','7','8')

    // 在可变数量参数中， 数组名前加指针*， 类似C 语言， 传递所有数组中元素
    val worldCharArray = charArrayOf('w', 'o', 'r', 'l', 'd')
    append(*worldCharArray)
    append('h', 'e', 'l', 'l', 'o','6','7','8','-',*worldCharArray)


}

//普通类
class Person
{
    fun test()
    {
        println("普通成员方法引用")
    }

    companion object Person2  // 这里取名是多余的行为，当然也可以
    {
       fun test2()
       {
           println("这是伴生companion object 对象方法的引用")
       }
    }
}

//静态类
object  NumUtils     //object 是小写的
{
    fun double(num:Int):Int
    {
        println("这是静态成员方法引用：  ${2*num}")
        return 2*num
    }
}

//companion object 伴生类--普通类中定义静态方法+非静态方法，都有的时候
//这个必须在一个普通类之中，不能单独放在外面
/*
companion object Person2   //单独写在外面出错
{

}*/

//-----------------------------------------
//函数的参数问题
//默认参数，具名参数，可变数量的参数
//默认参数
//主函数外可以有类，有函数---与c/c++ 像
fun read(offset:Int=0,start:Int)
{
    println("==============================================")
    println("单独函数with 默认参数 offset: "+offset)
    println("单独函数with 默认参数 start: "+start)

}

//方法可以做参数传入 ， action:()->Unit or Int...
//参数是（）说明是方法， 返回值用右箭头 -> , Unit 标识没有返回值，同java 中void
fun read(offset: Int=1,start: Int,action:()->Unit)
{
    println("==============================================")
    println("单独函数with 具名参数 offset: "+offset)
    println("单独函数with 具名参数 start: "+start)

    println(action())                     //方法的返回值就是方法的最后一句语句的返回值

}

////可变数量的参数--要求，只能一个参数标识 vararg, 如果它不是最后一个参数，可以使用具名参数的语法，给后面的参数传递值
fun append(vararg str:Char):String
{
    val result=StringBuffer()
    for (char in str)
    {
        result.append(char)
    }
    println(result.toString())
    return result.toString()
}



