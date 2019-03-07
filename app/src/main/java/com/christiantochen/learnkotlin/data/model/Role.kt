package com.christiantochen.learnkotlin.data.model

import androidx.room.Entity

@Entity(
    tableName = "roles",
    primaryKeys = ["id"]
)
data class Role(
    var id: Int,
    var name: String,
    var display_name: String
)