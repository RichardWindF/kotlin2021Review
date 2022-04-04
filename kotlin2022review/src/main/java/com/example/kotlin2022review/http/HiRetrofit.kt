package com.example.kotlin2022review.http

import com.example.kotlin2022review.bean.Account
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//这种方法就可以用  类名。方法 来调用里面的方法
object HiRetrofit
{

    val okhttpClient= OkHttpClient()


    //new  Retrofit.Builder()
    private val retrofit:Retrofit = Retrofit.Builder()
        .client(okhttpClient)
        //.baseUrl("http://123.56.232.18:8080/serverdemo/")
        .baseUrl("https://www.cnn.com")
        .addConverterFactory(GsonConverterFactory.create())  //数据转换器,这个还有吗？红线提示
        .build()


//         private val retrofit =new  Retrofit.Builder()
//        .client(okhttpClient)
//        .baseUrl("http://123.56.232.18:8080/serverdemo/")
//        .addConverterFactory(GSONConverterFactory.create())
//        .build();
//
//    val mApi = retrofit.create(ApiService.class);

    //public <T> T create(final Class<T> service)      //从 Retrofit 类中copy 出这个函数头，就不用自己写了
    fun <T>create(clazz:Class<T>):T
    {
        return retrofit.create(clazz)
    }

}

interface ApiService
{
    //参阅文档中的黑屏记录的常用API
    @GET(value = "user/query")
    //fun queryUser(@Query(value = "userId",encoded = true) userId:String):Call<String>
    fun queryUser(@Query(value = "userId",encoded = true) userId:String):Call<Account>

}