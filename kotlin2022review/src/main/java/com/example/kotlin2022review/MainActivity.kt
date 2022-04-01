package com.example.kotlin2022review

import android.annotation.SuppressLint
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.button.MaterialButtonToggleGroup
import okhttp3.*
import okhttp3.internal.commonEmptyRequestBody
import okio.IOException

class MainActivity : AppCompatActivity()
{
    private val TAG = "`MainActivity.pre`"
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
        /*   val mRecyclerView = findViewById<RecyclerView>(R.id.linear_rv)
          // mRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)    //纵向
           mRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)  //横向
           mRecyclerView.adapter=MyAdapter()
   */
        val mRecyclerView = findViewById<RecyclerView>(R.id.linear_rv)
        // mRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)    // linearlayoutmanager纵向
        // mRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)  //横向

        //mRecyclerView.layoutManager=GridLayoutManager(this,2)  //gridlayoutmanager

        mRecyclerView.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        ) //StaggeredGridLayoutManager

        mRecyclerView.adapter = MyAdapter()

        //------------------------------------------------------------------------------------------------
        //  GET 请求 --下面4个函数选择运行一个测试

        //GET--同步
        //getOkHttpDataByGETSync()
        //GET--异步
        //getOkHttpDataByGETAsync()

        //----------------------------------
        //POST 请求
        //POST--同步
        //PostOkHttpDataByPostSync()
        //post--异步
        PostOkHttpDataByPostAsync()

    }


    //建请求
    //----------------------------------
    //POST 请求
    //POST--同步
    private fun PostOkHttpDataByPostSync()
    {
        Thread(object : Runnable
        {
            override fun run()
            {
                val mOkHttpClient = OkHttpClient()

                val requestBody=FormBody.Builder()
                    .add("fy","51.ca")
                    .build()

                val request = Request.Builder()
                    .url("https://www.51.ca")
                    .post(requestBody)
                    .build()

                val call = mOkHttpClient.newCall(request)
                val response = call.execute()

                var resultString: String? = null
                if (response.isSuccessful)
                {
                    resultString = response.body?.string()
                }

                val showTV = findViewById<TextView>(R.id.show_TV)

                runOnUiThread(object : Runnable
                {
                    override fun run()
                    {
                        showTV.setText("Post--同步" + resultString)
                    }

                })
            }

        }).start()

    }

    //post--异步
    private fun PostOkHttpDataByPostAsync()
    {
        val mOkHttpClient = OkHttpClient()

        val requestBody = FormBody.Builder()
            .add("fy", "51.ca post异步")
            .build()

        val request = Request.Builder()
            .url("https://www.51.ca")
            .post(requestBody)
            .build()

        val call = mOkHttpClient.newCall(request)
        call.enqueue(object : Callback
        {
            override fun onFailure(call: Call, e: okio.IOException)
            {

            }

            override fun onResponse(call: Call, response: Response)
            {

                if (response.isSuccessful)
                {
                    var resultString: String? = null
                    resultString = "Post--异步" + response.body?.string()

                    runOnUiThread(object : Runnable
                    {
                        override fun run()
                        {
                            findViewById<TextView>(R.id.show_TV).text=resultString
                            //也可以setText() 同上
                        }

                    })

                }

            }

        })


    }

    //------------------------------------------------------------------------
    //GET--同步
    private fun getOkHttpDataByGETSync()
    {
        Thread(object : Runnable
        {
            override fun run()
            {
                val mOkHttpClient = OkHttpClient()

                val request = Request.Builder()
                    .url("https://www.cnn.com")
                    .build()

                val call = mOkHttpClient.newCall(request)
                val response = call.execute()

                var resultString: String? = null
                if (response.isSuccessful)
                {
                    resultString = response.body?.string()
                }

                val textPost = findViewById<TextView>(R.id.show_TV)
                textPost.post(object : Runnable
                {
                    override fun run()
                    {
                        textPost.text = "GET--同步" + resultString
                    }
                })
            }


        }).start()
    }


    //GET--异步
    private fun getOkHttpDataByGETAsync()
    {

        val mOkHttpClient = OkHttpClient()

        val request = Request.Builder()
            .url("https://www.cnn.com")
            .build()

        val call = mOkHttpClient.newCall(request)

        //GET--异步
        call.enqueue(object : Callback
        {
            override fun onFailure(call: Call, e: IOException)
            {
            }

            override fun onResponse(call: Call, response: Response)
            {
                var resultString: String? = null
                if (response.isSuccessful)
                {
                    resultString = response.body?.string()
                }

                val textPost = findViewById<TextView>(R.id.show_TV)
                textPost.post(object : Runnable
                {
                    override fun run()
                    {
                        textPost.text = "GET--异步" + resultString
                    }
                })
            }

        })


    }
}