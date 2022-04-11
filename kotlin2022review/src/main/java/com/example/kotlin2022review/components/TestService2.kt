package com.example.kotlin2022review.components

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

//此例用于测试 binder 方式启动 Service---C(S) BUD
class TestService2 : Service() {
    private val TAG = "TestService2"
    private var count = 0
    private var quit = false

    //----------------------------
    //定义onBinder 方法所返回的对象
    //class MyBind:Binder()
    inner class MyBinder : Binder() {
        fun getCount(): Int {
            return count
        }
    }

    //---------------------------------------
    override fun onBind(p0: Intent?): IBinder? {
//        var i=0   //这个计数可以不要--不是写在这里，而是下面
//       for(i in 0..100)
//       {
//           count++
//       }
        Log.e(TAG, "onBind: 被调用")
        return MyBinder()
    }

    //-----------------------------------

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate: ")
        //----------------
        //创建线程动态修改count的值  //注意这个写法与Java的不同

        object : Thread() {                    //这里不加object: 就引导不出后面的重写函数RUN
            override fun run() {
                while (!quit) {
                    sleep(1000)      //最好try-catch 起来
                    count++
                }
            }
        }.start()

        Thread(Runnable {
            Thread.sleep(1000)
        })
    }


   // service 断开连接时候回调
    override fun onUnbind(intent: Intent?): Boolean {
        //return super.onUnbind(intent)
       Log.i(TAG, "onUnbind: 方法被调用")
       return true
    }

    // service 关闭的时候回调
    override fun onDestroy() {
        super.onDestroy()
        quit=true
        Log.i(TAG, "onDestroy: 方法被调用")
    }

}