package com.example.fragmenttab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val helper = MainHelper(this)
    private val items by lazy {
        helper.items
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // init bottom menu
        bnv_navigation.inflateMenu(helper.navigationMenuResId)
        bnv_navigation.enableAnimation(false)
        bnv_navigation.enableShiftingMode(false)
        bnv_navigation.enableItemShiftingMode(false)
        bnv_navigation.onNavigationItemSelectedListener = oNNavigationItemSelectedListener
        bnv_navigation.setIconTintList(0, null)
        bnv_navigation.setIconTintList(1, null)
        // 主页
        bnv_navigation.selectedItemId = bnv_navigation.menu.getItem(0).itemId
    }

    private val oNNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateItem(item.itemId)
    }

    private fun navigateItem(@IdRes menuId: Int): Boolean {
        val item = items.find { model ->
            menuId == model.resId
        }
        if (item != null) {
            navigateReplace(item.fragment, item.title)
            return true
        }
        return false
    }

    private fun navigateReplace(dst: Fragment, title: CharSequence? = null, isAddStack: Boolean = false) {
        if (!TextUtils.isEmpty(title)) {
            setTitle(title)
        }
        FragmentUtils.replace(supportFragmentManager, dst, R.id.fl_fragment_container, isAddStack)
    }
}
