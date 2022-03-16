package com.example.kotlin2022review.reviewKotLin

// kotlin 泛型
fun main()
{

    //1: 泛型接口
    val drinkApple = DrinkApple()
    drinkApple.drink("苹果汁好喝")

    println("--------------------------------------")
    //2:泛型类
    val blueColor = BlueColor("blue")
    blueColor.printColor()

    //3:泛型方法  的调用
    fromJson("{}",String::class.java)
}

//---接口
interface Drinks<T>
{
    fun drink(t:T)
}

class DrinkApple:Drinks<String>
{
    override fun drink(t: String)
    {
        println("drink: $t")
    }
}

//--类
abstract class Color<T>(val t:T)    //抽象类
{
    abstract fun printColor()
}

class BlueColor(val color:String): Color<String>(color)
{
    override fun printColor()
    {
        println("Color is $color")
    }

}

//------3:泛型方法------------

fun <T>fromJson(json:String,tClass:Class<T>):T?
{
    val instance:T? = tClass.newInstance()
    return instance
}