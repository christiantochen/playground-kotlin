package com.christiantochen.learnkotlin

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.christiantochen.learnkotlin.injection.component.DaggerViewModelInjector
import com.christiantochen.learnkotlin.injection.component.ViewModelInjector
import com.christiantochen.learnkotlin.injection.module.NetworkModule
import com.christiantochen.learnkotlin.ui.login.LoginViewModel

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