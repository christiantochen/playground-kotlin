package com.christiantochen.learnkotlin.data.remote

import com.christiantochen.learnkotlin.data.model.User

data class LoginResponse(val token: String?) : BaseResponse<User?>()