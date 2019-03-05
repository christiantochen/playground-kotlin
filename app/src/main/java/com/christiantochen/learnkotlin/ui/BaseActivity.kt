package com.christiantochen.learnkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import com.christiantochen.learnkotlin.utils.extension.postDelayed
import com.christiantochen.learnkotlin.utils.extension.showToast

abstract class BaseActivity :
    AppCompatActivity() {
    private var doubleBackToExitPressedOnce: Boolean = false
    override fun onBackPressed() {
        if (this.doubleBackToExitPressedOnce) {
            super.onBackPressed()
        } else {
            this.doubleBackToExitPressedOnce = true
            this.showToast("Please click BACK again to exit")
            postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
        }
    }
}
