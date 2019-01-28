package com.christiantochen.ppjonline.ui.splash

import android.content.Intent
import android.os.Bundle
import com.christiantochen.ppjonline.R
import com.christiantochen.ppjonline.ui.BaseActivity
import com.christiantochen.ppjonline.ui.login.LoginActivity
import com.christiantochen.ppjonline.ui.main.MainActivity
import com.christiantochen.ppjonline.utils.extension.postDelayed


class SplashActivity : BaseActivity()
{
    private val SPLASH_DURATION: Long = 3000 // 3 seconds

    private val runNextActivity: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(this, LoginActivity::class.java);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ThemeSplash)
        super.onCreate(savedInstanceState)

        //Navigate with delay
        postDelayed(runNextActivity, SPLASH_DURATION)
    }
}
