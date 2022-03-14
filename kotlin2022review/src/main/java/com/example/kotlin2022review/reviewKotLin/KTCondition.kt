package com.example.kotlin2022Review.reviewKotLin

import android.view.Gravity.apply

fun main()
{
    val max = max(5, 23)
    println("max="+max)

    val max2 = max2(35, 65)
    println("max2="+max2)

    println(eval(135.5))
    println(eval(5.575f))
    println(eval(100f))
    eval(55)
}

//------------if..else--------------------------------
fun max(a:Int, b:Int)=if(a>=b) a else b     //这种方法最简单， 3目

fun max2(a:Int, b:Int):Int
{
    if(a>=b) return a
    else return b
}

//-------when-----------------------------
//---这个如果用if--else 是多层嵌套
// is--是判断是否某种类型
fun eval(number:Number):String= when (number){
        100f->"$number is 100f".apply (::println )
        is Int->"$number is Integer".apply (::println )
        is Double->"$number is Double"
        is Float->"$number is Float"
        is Long->"$number is Long"
        is Short->"$number is Short"
        else ->"invalid $number"

    }


/*fun eval2(value:Any)
{
    val value:Any =getValue()  //这个地方好像右点问题
    return when(value)
    {
        //100f -> "number is float"
        is Int->"number is Integer".apply(::println)

        else ->
        {"I know"
        }.apply(::println)
    }
}*/

fun getValue(): Any=100f
// 等同 fun getValue(): Any{ return 100f}


