package com.christiantochen.ppjonline

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.christiantochen.ppjonline.injection.component.DaggerViewModelInjector
import com.christiantochen.ppjonline.injection.component.ViewModelInjector
import com.christiantochen.ppjonline.injection.module.NetworkModule
import com.christiantochen.ppjonline.ui.login.LoginViewModel
import android.view.View

abstract class BaseViewModel :
        ViewModel()
{
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