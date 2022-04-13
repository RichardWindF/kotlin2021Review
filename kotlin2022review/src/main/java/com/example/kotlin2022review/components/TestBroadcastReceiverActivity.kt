package com.example.kotlin2022review.components

import android.content.IntentFilter
import android.net.ConnectivityManager.CONNECTIVITY_ACTION
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.ConnectivityManagerCompat

class TestBroadcastReceiverActivity: AppCompatActivity()
{
    private lateinit var mReceiver: TestBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        mReceiver = TestBroadcastReceiver()
        val intentFilter = IntentFilter()

        //intentFilter.addAction(ConnectivityManagerCompat.CONNECTIVITY_ACTION)  //弃用报错

        registerReceiver(mReceiver,intentFilter)
    }

    override fun onDestroy()
    {
        super.onDestroy()
        unregisterReceiver(mReceiver)
    }
}