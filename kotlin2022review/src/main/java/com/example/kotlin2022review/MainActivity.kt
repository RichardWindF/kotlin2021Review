package com.example.kotlin2022review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.comps_linearlayout)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            view ->  button.setText("I love Canada！")
        })
    }
}