package com.example.kotlin2022review

import android.annotation.SuppressLint
import android.content.Context
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
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
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.internal.commonEmptyRequestBody
import okio.IOException
import org.json.JSONObject
import java.io.File

class MainActivity : AppCompatActivity()
{
    private val TAG = "MainActivity1"
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

        //--------------------------------------
        //多表单文件上传
        //postAsyncMultipart(this)

        //-------------------------------------------
        //异步提交字符串 ... post， enqueue
        postAsyncString(this)

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

    //------------------------------------------------
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

    //----------------------------------------------
    // post 异步请求-多表单文件上传---这个用的时候再查

    private  fun postAsyncMultipart(context:Context)
    {
        var mOkHttpClient = OkHttpClient()

        //Android 6.0及以后，对外部存储卡什么的读写，都要动态再申请权限，由用户确定。无论AndroidManifest.xml中是否有存储权限申请
        val file= File(Environment.getExternalStorageDirectory(),"1.png")       //文件地址？
        if (!file.exists())
        {
            Toast.makeText(context,"文件不存在",Toast.LENGTH_SHORT).show()
            return
        }

        val multipartBody=MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("key1","value1")
            .addFormDataPart("key2","value2")
            .addFormDataPart("file","file.png",RequestBody.create("application/octet-stream".toMediaTypeOrNull(),file))
                             //上传文件1： 接受文件的名字， 2：上传的？
            .build()


        val request = Request.Builder()
            .url("https://www.51.ca")  //这个接口需要支持文件上传才可以使用的
            .post(multipartBody)
            .build()

        val call = mOkHttpClient.newCall(request)

        //call.execute()--同步, 这里选异步
        call.enqueue(object: Callback
        {
            override fun onFailure(call: Call, e: IOException)
            {
                Log.e(TAG, "postAsyncMultipart onFailure:${e.message} ")
            }

            override fun onResponse(call: Call, response: Response)
            {
                Log.e(TAG, "postAsyncMultipart onResponse:${response.body?.string()} ")
            }

        })    // call.execute()--同步

    }

    //-------------------------------------------
    //异步提交字符串 ... post， enqueue
    private fun postAsyncString(context: Context)
    {
        val mOkHttpClient = OkHttpClient()

        val jsonObject = JSONObject()      //此处以 json 数据为例子  (他们是MAP 数据)
        jsonObject.put("key1","value1")
        jsonObject.put("key2",100)

       // val reqeustBody=RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(),jsonObject.toString())
        val reqeustBody= jsonObject.toString()    //上面弃用，根据提示来到 string.toRequestBody()
            .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

        val request=Request.Builder()
            .url("https://www.51.ca")
            .post(reqeustBody)
            .build()

        val call = mOkHttpClient.newCall(request)
        call.enqueue(object: Callback
        {
            override fun onFailure(call: Call, e: IOException)
            {
                Log.e(TAG, "postAsyncString onFailure:${e.message} ")
            }

            override fun onResponse(call: Call, response: Response)
            {
                Log.e(TAG, "postAsyncString onResponse:${response.body?.string()} ")

            }

        })


    }



}