package com.example.kotlin2022review.reviewKotLin

//List, Set, Map
//List, 有序，可重复元素
//Set,  无序，不重复
//Map,  键值对， key唯一，value 可重复 <key,value>

fun main()
{
    //列表的创建方式--可变列表
    //List--ArrayList(), mutableListOf() 功能一样
    val arrayList = arrayListOf<Int>(1, 2, 3)
    val arrayString = mutableListOf<String>()

    arrayString.add("I love your-Kotlin!")
    arrayString.add("I love your-Java!")
    arrayString.add(2, "this is 3th elements of arrayString!")

    for (str in arrayString)
        println(str)

    //列表的创建方式--不可变列表
    //listOf()-需要指定类型，以及初始化
    val array = listOf<Int>(1, 2, 3)
    for (element in array)
        println(element)
    println("-------------------------------")

    array.forEach()
    {
        println(it)
    }

    //---Map
    // 可变字典Map
    //arrayMapOf() 或者 mutableMapOf()---注意这里不是Java的 HashMap()
    val hashMap = HashMap<Int, String>()     //java 中的 hashMap 还是可以使用
    //val array3=arrayMapOf()//--已经不能识别
    //val arrayMap1= mutableMapOf(Pair("key","value"))
    val arrayMap = mutableMapOf<Int, String>()
    arrayMap.put(2, "wangy")
    arrayMap[1] = "fengy"                                //注意这两种引用方法均可

    arrayMap.forEach()
    {
        println("${it.key}-->" + it.value)
    }

    // 不可变字典Map
    //mapOf()
    val mMap = mapOf<String, String>()
    //mMap.add//没有。。所以不能动态添加，删除等
    val mMap2 = mapOf<String, String>(Pair("key", "value"))   //这种才有内容

    println("-------------------------------")
    //关于Set
    //可变Set
    // val mSet= arraySetOf<String,String>()    //已经删除了，不可用
    val mSet = mutableSetOf<String>()
    mSet.add("who are you?")
    val mSet2 = mutableSetOf<String>("I", " am ", " fy.")
    mSet2.add("kkkkkkk")
    mSet2.add("I")           //元素自动去重
    //mSet2[1]= 这种方法访问对Set 不可以

    mSet.forEach()
    {
        println("mSet is $it")     //如果集合是空，就不会打印任何东西，进不去这句？
    }
    mSet2.forEach() { println("mSet2 is ${mSet2.toString()}") }

    //不可变
    val mSet3 = setOf<Int>(1, 3, 5, 1)     ////元素自动去重，只有3项
    //mSet3.add//没有。。所以不能动态添加，删除等
    mSet3.forEach() { println("mSet3 is $it") }

    println("oooooooooooooooooooooooooooooooooooooooooooooo")
    //集合常用函数
    val arrayExample = mutableListOf<String>("1", "2", "3", "4", "5", "2")
    println("isEmpty(): ${arrayExample.isEmpty()}")
    println("contains(): ${arrayExample.contains("5")}")
    println("get(key): ${arrayExample.get(4)}")
    println("indexOf(value): ${arrayExample.indexOf("2")}")
    println("lastIndexOf(value): ${arrayExample.lastIndexOf("2")}")

    val iterator = arrayExample.iterator()  // 或者与 forEach 一起使用
    while (iterator.hasNext())
        println("iterator():${iterator.next()}")

    val iterator1=arrayExample.iterator()                      //迭代器已经到底部，需要重新设置
    iterator1.forEach()
    {
        print("iterator(): $it, ")
    }
    println()

    arrayExample.set(1,"888")
    arrayExample[2]="999"
    println(arrayExample.toString())

    println("-------------其它相关集合的操作------------------------------")
    //其它相关集合的操作

    val numbers= mutableListOf<Int>(1,2,3,4)
    numbers.reverse()// 反转
    println(numbers)

    numbers.shuffle()  //随机
    numbers.forEach(){
        println(it)
    }

    numbers.sort() // 升序
    println(numbers)

    numbers.sortDescending() //降序
    println(numbers)

    







}