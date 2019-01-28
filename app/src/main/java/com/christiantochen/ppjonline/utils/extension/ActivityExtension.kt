package com.christiantochen.ppjonline.utils.extension

import android.app.Activity
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import android.view.View

fun Activity.getRootView(): View {
    return findViewById(android.R.id.content)
}

fun Activity.showToast(text: String) {
    val toast = Snackbar.make(this.getRootView(), text, Snackbar.LENGTH_LONG)
        .setAction("Action", null)
    toast.show()
}