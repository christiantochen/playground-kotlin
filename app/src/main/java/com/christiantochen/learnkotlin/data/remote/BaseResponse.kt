package com.christiantochen.learnkotlin.data.remote

open class BaseResponse<T> {
    val message: String? = null
    val data: T? = null
}