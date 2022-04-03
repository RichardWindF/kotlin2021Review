package com.example.kotlin2022review.bean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun main()
{

    //------------------------------------------
    //  Json 数据--> 类对象
    val jsonString="{\"uid\":\"00001\",\"userName\":\"freeman1\",\"telNumber\":\"1800000\"}"
   // val json =    "{\"uid\":\"00001\",\"userName\":\"Freeman\",\"telNumber\":\"13000000000\"}";

    val gson= Gson()
    val account:Account=gson.fromJson<Account>(jsonString,Account::class.java)

    println("fromJson:  "+account)

    //------------------------------------------
    // 类对象 --> Json 数据字符串

    val gson2=Gson()
    //account=new Account()
    val account2=Account()
     println("toJson: "+gson2.toJson(account2))

    //------------------------------------------
    // Json 数据字符串(中括号开始的数组那种)--> 集合列表中
    val jsonList= "[{\"uid\":\"00001\",\"userName\":\"Freeman\",\"telNumber\":\"13000000000\"}" +
            ",{\"uid\":\"00002\",\"userName\":\"Freeman\",\"telNumber\":\"13000000000\"}" +
            ",{\"uid\":\"00003\",\"userName\":\"Freeman\",\"telNumber\":\"13000000000\"}]"

    val accountList:List<Account> = gson.fromJson<List<Account>>(jsonList,object :TypeToken<List<Account>>(){}.type)
    println("json-->collections, list.size():="+ accountList.size)

//------------------------------------------
    // 集合对象 --> Json 数据字符串

    val listToJsonString = gson.toJson(jsonList)
    println("collections(List)->Json:  "+listToJsonString )


}
class Account
{
    var uid:String="abc"
    var userName="freeman"
    var password="password"
    var telnumber="1300000"

    override fun toString(): String
    {
        return "Account(uid='$uid', userName='$userName', password='$password', telnumber='$telnumber')"
    }


}


