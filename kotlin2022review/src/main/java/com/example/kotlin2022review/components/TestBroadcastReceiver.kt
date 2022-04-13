package com.example.kotlin2022review.components

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

import android.net.ConnectivityManager.CONNECTIVITY_ACTION
import android.net.NetworkInfo
import android.widget.Toast
import androidx.core.net.ConnectivityManagerCompat

class TestBroadcastReceiver : BroadcastReceiver()
{
    override fun onReceive(context: Context?, intent: Intent?)
    {
        val action:String = intent?.action ?: return

       // if (action.equals(ConnectivityManagerCompat.CONNECTIVITY_ACTION))            //这个已经弃用了
      //  if (action.equals(ConnectivityManagerCompat.CONNECTIVITY_ACTION))            //这个已经弃用了
        {
            val connectivityManager: ConnectivityManager=
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info:NetworkInfo?=connectivityManager.activeNetworkInfo

            if(info!=null && info.isAvailable)
            {
                //有网络链接的
                val typeName:String = info.typeName
                Toast.makeText(context,"当前网络链接类型：${typeName}",Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(context,"当前无网络链接",Toast.LENGTH_SHORT).show()
            }
        }
    }

}