package com.example.kotlin2022review

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ToggleButton
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
            val childCount = group.childCount
            var selectIndex = 0

            for (index in 0 until childCount)        //[0, childCount)
            {
                // val childAt = (MaterialButton)group.getChildAt(index)
                val childAt = group.getChildAt(index) as MaterialButton  //kotlin 中的类型转换
                if (checkedId == childAt.id) {
                    selectIndex = index
                    childAt.setTextColor(Color.RED)
                    childAt.iconTint = ColorStateList.valueOf(Color.RED)
                } else {
                    childAt.setTextColor(Color.BLACK)
                    childAt.iconTint = ColorStateList.valueOf(Color.BLACK)
                }

            }

            switchFragment(selectIndex)
        }

        toggleGroup.check(R.id.tab1)
    }

    private var tab1Fragment: SecondFragment? = null
    private var tab2Fragment: SecondFragment? = null
    private var tab3Fragment: SecondFragment? = null
    private fun switchFragment(selectIndex: Int) {
        val fragment: SecondFragment? = when (selectIndex) {
            0 -> {
                if (tab1Fragment == null) {
                    tab1Fragment = SecondFragment()

                    // val bundle=
                }
                tab1Fragment
            }
            1 -> {
                if (tab2Fragment == null) {
                    tab2Fragment = SecondFragment()
                }
                tab2Fragment
            }
            2 -> {
                if (tab3Fragment == null) {
                    tab3Fragment = SecondFragment()
                }
                tab3Fragment
            }
            else ->
                throw IllegalAccessException("ERROR-下标不符合预期")
        }

    }
}
