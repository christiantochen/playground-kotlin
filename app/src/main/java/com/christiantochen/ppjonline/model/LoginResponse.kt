package com.christiantochen.ppjonline.model

data class LoginResponse(val token: String?, val kai_token: String?) : BaseResponse<User?>()