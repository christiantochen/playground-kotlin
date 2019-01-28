package com.christiantochen.ppjonline.ui

import androidx.appcompat.app.AppCompatActivity
import com.christiantochen.ppjonline.utils.extension.postDelayed
import com.christiantochen.ppjonline.utils.extension.showToast

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
