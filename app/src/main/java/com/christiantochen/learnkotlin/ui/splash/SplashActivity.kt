package com.christiantochen.learnkotlin.ui.splash

import android.content.Intent
import android.os.Bundle
import com.christiantochen.learnkotlin.R
import com.christiantochen.learnkotlin.ui.BaseActivity
import com.christiantochen.learnkotlin.ui.login.LoginActivity
import com.christiantochen.learnkotlin.ui.main.MainActivity
import com.christiantochen.learnkotlin.utils.extension.postDelayed


class SplashActivity : BaseActivity()
{
    private val SPLASH_DURATION: Long = 3000 // 3 seconds

    private val runNextActivity: Runnable = Runnable {
        if (!isFinishing) {
//            val intent = Intent(this, LoginActivity::class.java)
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
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