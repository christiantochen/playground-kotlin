package com.christiantochen.learnkotlin.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.christiantochen.learnkotlin.R
import com.christiantochen.learnkotlin.databinding.ActivityMainBinding
import com.christiantochen.learnkotlin.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : BaseActivity()
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDrawer()
        setupViewModel()
        setupBinding()
        setupObserver()
    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> true.also { drawer_layout.openDrawer(GravityCompat.START) }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupDrawer() {
        setSupportActionBar(toolbar)
//        val actionBar: ActionBar? = supportActionBar
//        actionBar?.apply {
//            setHomeAsUpIndicator(R.drawable.baseline_menu_white_24)
//            setDisplayHomeAsUpEnabled(false)
//        }
//        toolbar.setLogo(R.drawable.baseline_menu_white_24)
//        supportActionBar?.setLogo(R.drawable.baseline_menu_white_24)
//        val drawerToggle  = ActionBarDrawerToggle(
//            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
//        drawer_layout.addDrawerListener(drawerToggle)
//        drawerToggle.isDrawerIndicatorEnabled = true
//        drawerToggle.setHomeAsUpIndicator(R.drawable.baseline_menu_white_24)
//        drawer_layout.addDrawerListener(drawerToggle)
//        drawerToggle.syncState()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
    }

    private fun setupObserver() {

    }
}
