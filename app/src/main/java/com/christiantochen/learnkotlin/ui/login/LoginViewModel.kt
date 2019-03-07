package com.christiantochen.learnkotlin.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.christiantochen.learnkotlin.BaseViewModel
import com.christiantochen.learnkotlin.data.remote.LoginRequest
import com.christiantochen.learnkotlin.data.remote.LoginResponse
import com.christiantochen.learnkotlin.network.LoginApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class LoginViewModel :
    BaseViewModel()
{
    @Inject
    lateinit var loginApi: LoginApi
    private lateinit var subscription: Disposable

    val navigateToMainActivity: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { setValue(false) }
    val username: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    fun login() {

        if(!validate())
        {
            errorMessage.value = "Username or Password cannot be empty"
            return
        }

        subscription = loginApi.login(
            LoginRequest(
                username.value!!,
                password.value!!
            )
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onLoginStart() }
                .doOnTerminate { onLoginFinish() }
                .subscribe(
                    { r -> onLoginSuccess(r) },
                    { e -> onLoginError(e) }
                )
    }

    private fun onLoginStart(){
        isLoading.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onLoginFinish(){
        isLoading.value = View.GONE
    }

    private fun onLoginSuccess(r: LoginResponse){
        navigateToMainActivity.value = true
    }

    private fun onLoginError(e: Throwable){
        if(e is HttpException)
        {
            when(e.code())
            {
                401, 403 -> errorMessage.value = "Username or Password Invalid"
                else -> errorMessage.value = e.message
            }
        }

    }

    private fun validate() : Boolean {
        return !username.value.isNullOrBlank() && !password.value.isNullOrBlank()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}