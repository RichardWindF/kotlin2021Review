package com.example.kotlin2022review.fragments

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kotlin2022review.R
import com.example.kotlin2022review.components.TestBroadcastReceiverActivity
import com.example.kotlin2022review.components.TestServiceActivity

class SecondFragment :Fragment()
{
    companion object
    {
        private const val TAG = "SecondFragment"
    }


    override fun onAttach(context: Context)
    {
        super.onAttach(context)
        Log.e(SecondFragment.TAG, "onAttach: ", )
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate: ", )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val textView=TextView(context)
        textView.setText("Canada secondFragment")
        textView.gravity=Gravity.CENTER

        Log.e(TAG, "onCreateView: ", )

        return textView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabNameString = arguments?.getString("tab")    // 获取了 SecondActivity.kt 传来的值
        //R.id.container   //创建了view后有了view可以操作

        //view 先转成Text view 对象，再设文本内容
        val textView = view as TextView

        textView.text=tabNameString

        //这里希望点击中间文本，打开测试 service 的activity
        textView.setOnClickListener(object:View.OnClickListener
        {
            override fun onClick(p0: View?) {
                //startActivity(Intent(context,TestServiceActivity::class.java))

                val intent = Intent(context, TestServiceActivity::class.java)   //测service
                //val intent = Intent(context, TestBroadcastReceiverActivity::class.java)   //测broadcast

                startActivity(intent)
            }

        }
        )




    }

    //----------------------------


    override fun onStart()
    {
        super.onStart()
        Log.e(TAG, "onStart: ", )
    }

    override fun onResume()
    {
        super.onResume()
        Log.e(TAG, "onResume: ", )
    }

    override fun onPause()
    {
        super.onPause()
        Log.e(TAG, "onPause: ", )

    }

    override fun onStop()
    {
        super.onStop()
    }

    override fun onDestroyView()
    {
        super.onDestroyView()    //onCreateView 返回的view对象被销毁的时候
        Log.e(TAG, "onDestroyView: ", )
    }

    override fun onDestroy()
    {
        super.onDestroy()     //fragment 对象被销毁的时候回调
        Log.e(TAG, "onDestroy: ", )
    }

    override fun onDetach()
    {
        super.onDetach()
        Log.e(TAG, "onDetach: ", )
    }


}