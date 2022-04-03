package com.example.kotlin2022review.okhttp

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer


//这个似乎作用不大
class LoggingInterceptor :Interceptor
{
    override fun intercept(chain: Interceptor.Chain): Response
    {
        val time_start=System.nanoTime()   //返回最准确的可用系统计时器的当前值，以毫微秒为单位
        val request:Request = chain.request()
        val response = chain.proceed(request)

        //-------------------------
        val buffer= Buffer()
        request.body?.writeTo(buffer)
        val requestBodyStr = buffer.readUtf8()     //这个就是request 转换成字符串的？

        Log.e("OkHttp-Interceptor", String.format("intercept sending request %s with params %s "
                                                       , request.url, requestBodyStr))
            //  %s  是占位符，由后面的参数vararg填充

        //------------------------------
        val bussinessData:String = response.body?.string()?:"reponse body null"   //为空给个默认的
        //okhttp 工作原理，这个response 的响应流 只能调用一次，其它地方再调用就报错，所这里封装一个新的response传出？
        val mediaType=response.body?.contentType()
       // val newBody=ResponseBody.create(mediaType,bussinessData)
        val newBody= bussinessData.toResponseBody(mediaType)


        val newResponse = response.newBuilder()
                             .body(newBody)        //builder
                             .build()

        val time_end=System.nanoTime()
        Log.e("OkHttp-Interceptor", String.format("intercept received response for %s in %.1fms>>>%s"
            , request.url, (time_end-time_start)/1e6, bussinessData))

        return newResponse    //然后MainActivity 中调用response 就都没有问题了

        //然后把它应用到 OkHttpClient 的定义处即可（MainActivity中）  ???? 没有使用这个！！！


    }
}