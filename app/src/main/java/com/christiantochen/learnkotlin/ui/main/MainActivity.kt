package com.christiantochen.learnkotlin.ui.main

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager.LayoutParams
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.christiantochen.learnkotlin.R
import com.christiantochen.learnkotlin.databinding.ActivityMainBinding
import com.christiantochen.learnkotlin.ui.BaseActivity
import com.christiantochen.learnkotlin.ui.dashboard.DashboardFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : BaseActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialSetup().also {
            setupDrawer()
            setupObserver()
        }
    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.dashboard_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> true.also { drawer_layout.openDrawer(GravityCompat.START) }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initialSetup() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_content, DashboardFragment.newInstance())
            .commit()
        navigation_view.setCheckedItem(R.id.menu_drawer_dashboard)
    }

    private fun setupDrawer() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.baseline_menu_white_24)
            setDisplayHomeAsUpEnabled(true)
        }

        navigation_view.setNavigationItemSelectedListener {
            val fragment = when(it.itemId) {
                R.id.menu_drawer_dashboard -> DashboardFragment.newInstance()
                else -> null
            }

            if(fragment != null) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment!!)
                    .addToBackStack(null)
                    .commit()
            }

            true.also { drawer_layout.closeDrawers() }
        }
    }

    private fun setupObserver() {

    }
}
