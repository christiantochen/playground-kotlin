package com.christiantochen.ppjonline.network

import com.christiantochen.ppjonline.model.LoginRequest
import com.christiantochen.ppjonline.model.LoginResponse
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