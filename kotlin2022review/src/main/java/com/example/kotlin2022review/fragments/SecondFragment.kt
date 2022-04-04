package com.example.kotlin2022review.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

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