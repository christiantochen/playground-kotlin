package com.christiantochen.learnkotlin.data.model

import androidx.room.Entity

@Entity(
    tableName = "areas",
    primaryKeys = ["id"]
)
data class Area(
    val id: Int,
    val name: String,
    val display_name: String
)