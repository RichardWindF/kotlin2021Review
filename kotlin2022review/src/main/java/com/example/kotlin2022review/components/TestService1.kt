package com.example.kotlin2022review.components

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


//本例是 为 startService() 方式， 只用下面三个函数复写即可


class TestService1 : Service() {

    private val TAG = "TestService1"

    override fun onBind(p0: Intent?): IBinder? {
        //这个主要是为 bind 方式服务的
      return null
    }

    //本例是 为 startService() 方式， 只用下面三个函数复写即可

    override fun onCreate() {
        super.onCreate()
        Log.i("TestService1", "onCreate: ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand: ")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy: ")
        super.onDestroy()
    }
}