package com.example.kotlin2022review.reviewKotLin

//循环
fun main()
{
    val arrayListOf = arrayListOf("Java", "Kotlin", "Android")
    val listOf = listOf<String>("Chinese", "English", "Janpnese")

    // for..
    for(item in arrayListOf) println("Compter language: $item")
    println("-------------------------------------")
    for(item in listOf) println("Language speaking: $item")

    println("-------------------------------------")
    listOf.forEach()
    {
        println(it)
    }

    println("-------------------------------------")
    listOf.forEach{println(it)}
    arrayListOf.forEachIndexed { index, item -> println("$index->$item") }

    // while and do..while()
    println("-------------------------------------")
    var count = 0
    while(count<listOf.size)
    {
        println("while---"+listOf.get(count))
        count++
    }

    count = 0
    do
    {
        println("do..while---"+listOf.get(count++))
    }while (count<listOf.size)

    // iterator 迭代区间
    for(i in 1..5) println("-1..5-"+i)
    for(i in 6 until 8) println(".6 until 8--"+i)
    for(i in 10 downTo 0 step 2)println(" 10 downTo 0, step 2--"+i)

    //break and continue
    for(i in 1..10) { if(i.equals(5)) break;print(" "+i)}
    println()
    for(i in 1..10){  if(i==5) continue; print(" "+i)}

}