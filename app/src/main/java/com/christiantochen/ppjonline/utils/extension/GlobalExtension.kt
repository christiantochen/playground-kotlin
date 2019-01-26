package com.christiantochen.ppjonline.utils.extension

import android.os.Handler

fun postDelayed(action: () -> Unit, delayMilis: Long) {
    Handler().postDelayed(action, delayMilis)
}

fun postDelayed(action: Runnable, delayMilis: Long) {
    Handler().postDelayed(action, delayMilis)
}