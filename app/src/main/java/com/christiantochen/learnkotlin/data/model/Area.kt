package com.christiantochen.learnkotlin.data.model

import androidx.room.PrimaryKey

data class Area(
    @PrimaryKey
    val id: Int,
    val name: String,
    val display_name: String
)