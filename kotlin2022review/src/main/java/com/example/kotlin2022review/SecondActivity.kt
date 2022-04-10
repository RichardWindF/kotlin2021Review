package com.example.kotlin2022review

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.kotlin2022review.fragments.SecondFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val fragment = SecondFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commitAllowingStateLoss()


        val toggleGroup = findViewById<MaterialButtonToggleGroup>(R.id.toggle_group)

        toggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            val childCount = group.childCount        //按钮个数
            var selectIndex = 0

            for (index in 0 until childCount)        //[0, childCount)
            {
                // val childAt = (MaterialButton)group.getChildAt(index)
                val materialButton = group.getChildAt(index) as MaterialButton  //kotlin 中的类型转换
                if (checkedId == materialButton.id) {
                    selectIndex = index
                    //设置文本和图标的颜色
                    materialButton.setTextColor(Color.RED)
                    materialButton.iconTint = ColorStateList.valueOf(Color.RED)
                } else {
                    materialButton.setTextColor(Color.BLACK)
                    materialButton.iconTint = ColorStateList.valueOf(Color.BLACK)
                }

            }

            switchFragment(selectIndex)
        }

        toggleGroup.check(R.id.tab1)
    }

    private var tab1Fragment: SecondFragment? = null
    private var tab2Fragment: SecondFragment? = null
    private var tab3Fragment: SecondFragment? = null
    private var tab4Fragment: SecondFragment? = null

    private var shownFragmen: SecondFragment? = null   //为了解决重影问题，要隐藏不显示的fragment

    private fun switchFragment(selectIndex: Int) {
        //每一个tab 创建一个对应的fragment
        val fragment: SecondFragment? = when (selectIndex) {
            0 -> {
                if (tab1Fragment == null) {
                    tab1Fragment = SecondFragment()
                    //-----------传递数据
                    val bundle = Bundle()
                    bundle.putString("tab", "tab1")
                    tab1Fragment!!.arguments = bundle
                    //-----------------------------------

                }
                tab1Fragment
            }
            1 -> {
                if (tab2Fragment == null) {
                    tab2Fragment = SecondFragment()
                    //-----------传递数据
                    val bundle = Bundle()
                    bundle.putString("tab", "tab2")
                    tab2Fragment!!.arguments = bundle
                    //-----------------------------------
                }
                tab2Fragment
            }
            2 -> {
                if (tab3Fragment == null) {
                    tab3Fragment = SecondFragment()

                    //-----------传递数据
                    val bundle = Bundle()
                    bundle.putString("tab", "tab3")
                    tab3Fragment!!.arguments = bundle
                    //-----------------------------------
                }
                tab3Fragment
            }
            3 -> {

                if (tab4Fragment == null) {
                    tab4Fragment = SecondFragment()
                    //-----------传递数据
                    val bundle = Bundle()
                    bundle.putString("tab", "tab4")
                    tab4Fragment!!.arguments = bundle
                    //-----------------------------------
                }
                tab4Fragment
            }
            else -> {
                throw IllegalAccessException("ERROR-下标不符合预期")
            }

        }

        //上面生成了fragment 后，需要动态加入
        //val ft:FragmentTransaction
        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()     //这里可以连续4个点，如果不判断的话
            /* if (!fragment.isAdded) {
                 ft.add(R.id.container, fragment)
                     .show(fragment)
                     .commitAllowingStateLoss()
                     }*/

            if (!fragment.isAdded) {
                ft.add(R.id.container,fragment)
            }

            ft.show(fragment)
            if(shownFragmen!=null){
                ft.hide(shownFragmen!!)
            }

            shownFragmen=fragment
            ft.commitAllowingStateLoss()

            //引入了shownFragment 中间变量，从而解决了字的重影问题

        }

    }
}
