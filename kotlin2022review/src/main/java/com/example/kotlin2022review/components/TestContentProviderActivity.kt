package com.example.kotlin2022review.components

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.kotlin2022review.R
import java.util.jar.Manifest

class TestContentProviderActivity:AppCompatActivity()
{
    private val TAG = "TestContentProviderAct"
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.XXX)--这里没有调用这个也是木有问题的,只是木界面：-）
        setContentView(R.layout.activity_content_provider_test)

        initView()

        requestPermission()

    }

    private fun initView()
    {
        //增，
        findViewById<Button>(R.id.add_contact_btn).setOnClickListener {
            addContact()
        }

        // 删，
        findViewById<Button>(R.id.del_contact_btn).setOnClickListener {
            deleteContact()
        }


        // 改
        findViewById<Button>(R.id.update_contact_btn).setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?)     //注意这种方式和下面的方式的区别
            {
                updateContract()
            }

        })

        // 查，
        findViewById<Button>(R.id.get_contact_btn).setOnClickListener {
            getContacts()
        }


    }

    private fun deleteContact()
    {

    }

    private fun addContact()
    {
    }

    private fun updateContract()
    {

    }

    private fun requestPermission()
    {
        if ((ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED)
        )
        //如果未授权，就申请授权
        {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS
                    ,android.Manifest.permission.WRITE_CONTACTS), 100
            )
        } else
        {
            getContacts()
        }
    }

    @SuppressLint("Range")
    private fun getContacts()
    {
        
        //Toast.makeText(this,"读取通讯录权限获得,getContacts()",Toast.LENGTH_SHORT).show()
        val contentResolver =getContentResolver()    // contentResolver 这里一样的意思    //
        val uri:Uri = Uri.parse("content://com.android.contacts/data/phones" )      //联系人的uri

        val cursor: Cursor = contentResolver.query(uri, null, null, null, null,)?:return

       // while (cursor.moveToFirst())   //获取用户名和手机号
        while (cursor.moveToNext())   //获取用户名和手机号
        {
            //val displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val displayName = cursor.getString(cursor.getColumnIndex("display_name"))
           // cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            val telNumbeer = cursor.getString(cursor.getColumnIndex("data1"))

            Log.e(TAG, "getContacts: 姓名：$displayName", )
            Log.e(TAG, "getContacts: 电话号码：$telNumbeer", )

            Log.e(TAG, "getContacts: ===================", )
        }
        cursor.close()    //操作cursor 最后都必须关闭
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    )
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //与上面的申请时候放置的code 相同
        if (requestCode==100
            && permissions[0]==android.Manifest.permission.READ_CONTACTS
            &&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
           // getContacts()
            Toast.makeText(this,"读取通讯录权限获得",Toast.LENGTH_SHORT).show()
        } else
        {
            Toast.makeText(this,"读取通讯录权限被拒绝，无法继续",Toast.LENGTH_SHORT).show()
        }

    }
}