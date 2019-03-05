package com.christiantochen.learnkotlin.model

open class BaseResponse<T> {
    val message: String? = null
    val data: T? = null
}