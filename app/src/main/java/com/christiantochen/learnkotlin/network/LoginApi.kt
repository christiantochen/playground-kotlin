package com.christiantochen.learnkotlin.network

import com.christiantochen.learnkotlin.data.remote.LoginRequest
import com.christiantochen.learnkotlin.data.remote.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * The interface which provides methods to get result of webservices
 */
interface LoginApi {
    /**
     *
     */
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Observable<LoginResponse>
}