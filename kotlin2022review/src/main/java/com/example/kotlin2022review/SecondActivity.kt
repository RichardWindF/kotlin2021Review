package com.example.kotlin2022review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin2022review.fragments.SecondFragment

class SecondActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val fragment=SecondFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container,fragment)
            .commitAllowingStateLoss()
    }
}