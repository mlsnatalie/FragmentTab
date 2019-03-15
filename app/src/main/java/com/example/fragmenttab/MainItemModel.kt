package com.example.fragmenttab

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import java.io.Serializable


data class MainItemModel (@IdRes val resId: Int,
                     val fragment: Fragment,
                     val title: String): Serializable