package com.example.kotlin2022review.reviewKotLin


//=四则运算=
fun main()
{
    while (true)
    {
        println("==============四则运算=======================")
        println("please input your expression: ")

        val readLine = readLine()       //读取输入一行
        try
        {
            // if (readLine != null){ }--判空用下面的即可
            readLine?.let {
                val ret = caculate(it)
                //1+1=2
                println("$readLine=$ret")
                println("是否继续使用？y/n")
                val cmd: String? = readLine()

                cmd?.let {
                    if (it == "n")
                    {
                        System.exit(-1)   //退出程序
                    } else
                    {
                        //继续应用程序
                    }
                }


            }


        } catch (ex: Exception)
        {
            ex.printStackTrace()
        }
    }

}

fun caculate(input: String): String
{
    //input 1+1, 1-10, 1*11, 1/2
    if (input.contains("+"))             //判断输入数据是否包含 +，-，*，/
    {
        val nums: List<String> = input.trim().split("+")                     //去掉前后空格(包括中间的),切割-得到数据存入列表
        return operate( nums[0].toDouble(),nums[1].toDouble(),"+").toString()                      //字符串是不能直接运算的
    } else if(input.contains("-"))
    {
        val nums: List<String> = input.trim().split("-")                     //去掉前后空格,切割-得到数据存入列表
        return operate( nums[0].toDouble(),nums[1].toDouble(),"-").toString()
    }else if(input.contains("*"))
    {
        val nums: List<String> = input.trim().split("*")                     //去掉前后空格,切割-得到数据存入列表
        return operate( nums[0].toDouble(),nums[1].toDouble(),"*").toString()
    }else if(input.contains("/"))
    {
        val nums: List<String> = input.trim().split("/")                     //去掉前后空格,切割-得到数据存入列表
        return operate( nums[0].toDouble(),nums[1].toDouble(),"/").toString()
    }else
    {
        return "error: 你输入的表达式不对"
    }
}

fun operate(num1: Double, num2: Double, operate: String): Double
{
    return when (operate)
    {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> 0.0
    }

}


