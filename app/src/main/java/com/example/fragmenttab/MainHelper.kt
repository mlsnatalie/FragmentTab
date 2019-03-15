package com.example.fragmenttab

import android.app.Activity



class MainHelper(val activity: Activity) {

    val items by lazy {
        listOf(
                MainItemModel(R.id.main_home, HomeFragment(), activity.getString(R.string.main_home)),
                MainItemModel(R.id.main_mine, MineFragment(), activity.getString(R.string.main_mine))
        )
    }

    val navigationMenuResId = R.menu.main
}