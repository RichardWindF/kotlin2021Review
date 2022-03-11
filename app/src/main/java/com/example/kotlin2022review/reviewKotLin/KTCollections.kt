package com.example.kotlin2022review.reviewKotLin

fun main()
{
    //kotlin数组
    //创建  --arrayOf(), arrayOfNulls()
    val array1 = arrayOf(1, 3, 5, 6, 7, 8)
    //  val array2= arrayOf(1,"abc",true,JSONObject())

    val arrayOfNulls = arrayOfNulls<String?>(5)    //?表示可空
    arrayOfNulls[0] = "elements1"
    arrayOfNulls[1] = "elements2"
    arrayOfNulls[2] = "elements3"
    arrayOfNulls[3] = null

    for (mInt in array1) println(mInt)

    var count = 0;
    //  for(mInt in array2) println(mInt)
    // println("count=$count")

    for (mInt in arrayOfNulls)
        println("$mInt")

    //使用array 的构造函数，动态创建
    val asd = Array(5) { i -> (i * i).toString() }      //0,1,4,9,16--每个都是字符串

    //原生数组 及相应的定义及初始化方法
    val bytes = ByteArray(5)
    bytes[0] = 'a'.code.toByte()

    val intArray = IntArray(5)
    intArray[3] = 8

    val intArray2 = IntArray(3) { 100 }    //长度3， 每个值均为100
    for (mInt in intArray2)
        print("" + mInt + ",");
    println()

    val intArray3 = IntArray(5) { it * 2 } //{it*3}   //此处 it 自动识别位下标(其它标识不可以，自动)，所以【0，2，4，6，8】
    for (mInt in intArray3)
        print("" + mInt + ",");

    println()
    //数组遍历
    //----------------------
    //1： for ..in
    for (elements in intArray3)
        println(elements)
    //2： for--in ,下标indices, 根据下标取出对应位置的元素
    for (i in intArray3.indices)
    {
        println(i.toString() + "->" + intArray3[i])
    }

    //3:for..in ,  带索引（index,item） 数组名。withIndex（）  //固定单词/属性
    println("okokookokookokookokookokookokookoko111111111111111111111111111111111111111")
    //for((item,index) in intArray3.withIndex())  //这样些运行也能出结果，只是下面结果是 值->索引
    for ((index, item) in intArray3.withIndex())
    {
        println("$index->$item")
    }

    //4: forEach 循环--遍历元素值
    println("okokookokookokookokookokookokookoko22222222222222222222222222")
    intArray3.forEach { println(it) }  //依次回调数组中的元素 --0.2.4.6.8

    //5: forEach 加强版--遍历下标和元素值
    println("okokookokookokookokookokookokookoko333333333333333333333333333333333333333")
    intArray3.forEachIndexed { index, item -> println("$index:$item") }

    //-----------------------------------------------




}