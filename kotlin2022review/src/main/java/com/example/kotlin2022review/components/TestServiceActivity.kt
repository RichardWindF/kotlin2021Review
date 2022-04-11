package com.example.kotlin2022review.components

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin2022review.R
import okhttp3.internal.applyConnectionSpec
import android.content.ServiceConnection as ServiceConnection

//整体上在fragment 中去启动这个activity， 然后在activity中再启动 service

class TestServiceActivity : AppCompatActivity()
{
    var conn:ServiceConnection?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_test_service)

        //startService_btn，   //。。不能用
        //R.id.startService_btn.setOn //不能用
        // 现在这个直接使用控件名自动生成对象使用的 插件被 Google 禁止使用了，有替代方案，但比较麻烦
        //也可以使用以前JAVA 的方式 findViewById()
        val startService_btn = findViewById<Button>(R.id.startService_btn)
//        startService_btn.setOnClickListener(object :View.OnClickListener{
//            override fun onClick(p0: View?) {
//                val intent=Intent(this@TestServiceActivity,TestService1::class.java)
//                startService(intent)
//            }
//        })

        startService_btn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent=Intent(this@TestServiceActivity,TestService1::class.java)
                startService(intent)
            }

        })

        val stopService_btn = findViewById<Button>(R.id.stopService_btn)
        startService_btn.setOnClickListener(object :View.OnClickListener
        {
            override fun onClick(p0: View?) {
                val intent = Intent(this@TestServiceActivity, TestService1::class.java)
                //val intent=Intent(this,TestService2::class.java)
                stopService(intent)
            }

        })

        //--------------------------------------------------------
        //测试 绑定方式 bind

        var myBind:TestService2.MyBinder?=null
        //var myBind=null
        //val conn = object : ServiceConnection      //此处如果不 写  object: ,就无法出现引导
        conn = object : ServiceConnection      //此处如果不 写  object: ,就无法出现引导
        {
            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {

                println("------onService Connected---------")
               // val myBind = p1 as TestService2.MyBind
                myBind = p1 as TestService2.MyBinder
               // myBind!!.getCount()

            }
            override fun onServiceDisconnected(p0: ComponentName?) {
                println("------onService DisConnected---------")
            }

        }

        val intent=Intent(this,TestService2::class.java)        //注意这个地方可以，上面却不可以用this?
        bindService(intent, conn as ServiceConnection, BIND_AUTO_CREATE)

        findViewById<Button>(R.id.startService_btn3).setOnClickListener(object:View.OnClickListener
        {
            override fun onClick(p0: View?) {
                Log.e("TestService2", "getCount:  ${myBind?.getCount()}", )
            }

        })

        findViewById<Button>(R.id.stopService_btn).setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                unbindService(conn as ServiceConnection)
                Log.e("TestService2", "unbindService 被调用 ", )
            }

        })



    }


    override fun onDestroy() {
        super.onDestroy()
        unbindService(conn!!)

        //var i:Int=35
    }




}