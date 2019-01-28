package com.christiantochen.ppjonline.ui.main

import android.os.Bundle
import com.christiantochen.ppjonline.R
import com.christiantochen.ppjonline.ui.BaseActivity


class MainActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        bottom_appbar.replaceMenu(R.menu.bottom_nav_drawer_menu)
//        bottom_appbar.setOnMenuItemClickListener { item ->
//            when(item!!.itemId) {
////                R.id.bottom_appbar_user -> showToast("user menu item is clicked!")
//            }
//            true
//        }
//        bottom_appbar.setNavigationOnClickListener {
//            showBottomNavigation()
//        }
    }

//    private fun showBottomNavigation() {
//        val bottomNavDrawerFragment = BottomNavigationFragment()
//        bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
//    }
}
