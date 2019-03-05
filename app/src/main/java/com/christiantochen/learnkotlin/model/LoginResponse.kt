package com.christiantochen.learnkotlin.model

data class LoginResponse(val token: String?) : BaseResponse<User?>()