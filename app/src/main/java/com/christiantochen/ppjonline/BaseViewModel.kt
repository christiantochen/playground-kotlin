package com.christiantochen.ppjonline

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.christiantochen.ppjonline.injection.component.DaggerViewModelInjector
import com.christiantochen.ppjonline.injection.component.ViewModelInjector
import com.christiantochen.ppjonline.injection.module.NetworkModule
import com.christiantochen.ppjonline.ui.login.LoginViewModel

abstract class BaseViewModel :
    ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val isLoading: MutableLiveData<Int> = MutableLiveData<Int>().apply { setValue(View.GONE) }

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is LoginViewModel -> injector.inject(this)
        }
    }
}