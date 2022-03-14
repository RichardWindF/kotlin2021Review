package com.example.kotlin2022review.reviewKotLin

fun main()
{
    val numbers= arrayOf(1,2,3,4)
    transform(numbers, action = {index, element ->  index*element})
    for(mInt in numbers){
        printer(mInt)
    }

    printer("-------------------------")
    transform(numbers){index, element -> index*element }
    numbers.forEach()
    {
        printer(it)
    }

    val arrayList = arrayListOf<Int>(1, 2, 3, 4)
    arrayList.forEachIndexed(action= { index, element ->
        println("forEachIndexed:$index->$element")})

    println("---------------------------------------------")
    arrayList.forEachIndexed(){index, item ->println("forEachIndexed:$index->$item")}



    val mutableList = mutableListOf<Int>(0, 1, 2, 3)

}

//----------------------------------------------------------
fun printer(o:Any)// Any=Object(java 中)
{
   // println("----------------------------------------------------------------------------")
    println(o)
}

fun transform(array:Array<Int>, action: (index:Int,element:Int) -> Int)
{
    for(index in array.indices)     //indices 就是下标
    {
        val newValue = action(index, array[index])
        array[index]=newValue
    }
}
