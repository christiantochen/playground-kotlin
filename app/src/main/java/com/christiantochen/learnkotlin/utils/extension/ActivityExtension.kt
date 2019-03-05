package com.christiantochen.learnkotlin.utils.extension

import android.app.Activity
import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Activity.getRootView(): View {
    return findViewById(android.R.id.content)
}

fun Activity.showToast(text: String) {
    val toast = Snackbar.make(this.getRootView(), text, Snackbar.LENGTH_LONG)
        .setAction("Action", null)
    toast.show()
}

fun Context.showToast(text: String) {
    val activity = this as Activity
    activity.showToast(text)
}