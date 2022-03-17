package com.example.kotlin2022review.reviewKotLin

import android.icu.number.IntegerWidth
import org.json.JSONObject

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
    fromJson("{}",String::class.java) //或者
    fromJson<String>("{}",String::class.java)

    //4: 泛型约束
    fromJson2("{}",JSONObject::class.java)
    fromJson2<JSONObject>("{}",JSONObject::class.java)

    //泛型方法
    fromJson3("{}",User::class.java)
    fromJson3<User>("{}",User::class.java)

    //5: 约束泛型的类型上限关键字 out
    open class Animal
    class DogAnimal:Animal()
    class CatAnimal:Animal()
    class WhiteDogAnimal:Animal()

    fun animalFun()
    {
        val animal:Animal= DogAnimal()
        //val animalList:ArrayList<Animal> = ArrayList<DogAnimal>()   //这句提示错
        //按道理说new 子类对象是可以赋值给父类对象的，但KOTLIN 中不能集合转型，
        // 方法1：可以用out关键字, 运行传入该类及其子类
        val animalList2:ArrayList<out Animal> =ArrayList<DogAnimal>()    //此时就无问题了

        //或者方法2
        //class ArrayList<out T>{}  //放这里或者外面
        val animalList3:ArrayList<Animal> = ArrayList<DogAnimal>()    //此时就无问题了

        //----------------------------------------------------------
        // 方法1：可以用in关键字, 运行传入该类及其父类
        //val animalList4:InArrayList<DogAnimal> =InArrayList<Animal>()    //此时提示有问题了
        val animalList4:InArrayList<in DogAnimal> =InArrayList<Animal>()    //此时就无问题了

        //或者方法2
        //class InArrayList<in T>{}  //放这里或者外面
        val animalList5:InArrayList<WhiteDogAnimal> = InArrayList<Animal>()    //此时就无问题了
    }



}

class ArrayList<out T>{}
class InArrayList<in T>{}

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

//------4: 泛型约束------------
//传入的是JSONObject 类型或其子类
fun <T:JSONObject> fromJson2(json: String,tClass: Class<T>):T?
{
    val newInstance = tClass.newInstance()
    return newInstance
}

fun <T> fromJson3(json: String,tClass: Class<T>):T?
    where T:JSONObject, T:Comparable<T>
{
    val newInstance = tClass.newInstance()
    return newInstance

}

class User:JSONObject(), Comparable<User>
{
    override fun compareTo(other: User): Int
    {
        //TODO("Not yet implemented")
        return -1
    }

}