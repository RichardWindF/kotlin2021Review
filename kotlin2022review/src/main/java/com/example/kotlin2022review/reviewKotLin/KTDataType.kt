package com.example.kotlin2022review.reviewKotLin

/**
 *
 * Mar-2-2022,  Kotlin2021AndroidStu 0-->实战
 *
 */

fun main() {                     //psvm
    //Kotlin 数据类型
    //整型
    val number = 10
    val bigNumber = 800000000
    val longNumber = 20L
    val byteNumber: Byte = 1

    //浮点型
    val doubleNumber = 3.1415926888
    val floatNumber = 3.1415926888f

    println("floatNumber:" + floatNumber)
    println("doubleNumber:" + doubleNumber)

    //字符型
    val char:Char='0'
    if (char in '0'..'9') {
        println("ch="+char)
    }

    //布尔型
    val isVisible=true
    val isVisiable:Boolean=false

    //字符串
    val str="abcde"
    val str1:String="abcdefg"

    for (char in str1)         //字符串输出
    {
        println(char)
    }

    println("str[2]="+str[2])    //c ,字符串可当数组访问

    //字符串模板表达式
    println("the result is $str") //字符串输出
    println("the str1 length is ${str1.length}") //

    //字符串链接
    val age = 10
    println("I am "+age+" years old!")

    //字符转义  \n 换行
    val helloWorld="Hello World!"
    println(helloWorld+"\n"+"how are you doing? ")

    //要求字符串内容是JSON 格式的
    val helloWorld3="{\"key\":\"value\"}"
    println(helloWorld3)

    //“”“ 3个引号的分界符
    val helloWorld4=""" {"key1":"value1"} """
    println(helloWorld4)

    //数据类型强制转换
    val number100=100
    val toByte = number100.toByte()
    val toInt = number100.toInt()
    val toShort = number100.toShort()
    val toLong = number100.toLong()
    val toFloat = number100.toFloat()
    val toDouble = number100.toDouble()
    val toChar = number100.toChar()

    println("转换为Byte1："+number100.toByte())
    println("转换为Byte2：${number100.toByte()}")

    println(toByte)
    println(toInt)
    println(toShort)
    println(toLong)
    println(toFloat)
    println(toDouble)
    println(toChar)

    //+,-,*,/, % 与c 语言相同;
    val sum=0;
    val a=15;
    val b=7;

    println("+="+(a+b))
    println("-="+(a-b))
    println("*="+(a*b))
    println("/="+(a/b))
    println("%="+(a%b))

    //位运算
    val vip=true
    val admin=false

    val result = vip and admin
    val result2 = 8 ushr 2
    println(result)
    println(result2)

    //数组--KTCollections.kt



}