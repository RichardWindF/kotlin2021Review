package com.example.kotlin2022review

import android.annotation.SuppressLint
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity()
{
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.comps_material_button)

        /* val button = findViewById<Button>(R.id.button)
         button.setOnClickListener(View.OnClickListener {
             view ->  button.setText("I love Canada！")
         })*/

        /*val toggleGroup = findViewById<MaterialButtonToggleGroup>(R.id.toggleGroup)
        toggleGroup.addOnButtonCheckedListener(object :
            MaterialButtonToggleGroup.OnButtonCheckedListener
        {
            override fun onButtonChecked(
                group: MaterialButtonToggleGroup?,
                checkedId: Int,
                isChecked: Boolean
            )
            {
                Toast.makeText(applicationContext, "checkedId:" + checkedId, Toast.LENGTH_SHORT)
                    .show()
                Log.e(TAG, "onButtonChecked: " + checkedId)
            }

        })*/
        /*ActivityMainBinding
        linear_rv.*/
        val mRecyclerView = findViewById<RecyclerView>(R.id.linear_rv)
       // mRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)    // linearlayoutmanager纵向
       // mRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)  //横向

        //mRecyclerView.layoutManager=GridLayoutManager(this,2)  //gridlayoutmanager

        mRecyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) //StaggeredGridLayoutManager

        mRecyclerView.adapter=MyAdapter()
    }
}