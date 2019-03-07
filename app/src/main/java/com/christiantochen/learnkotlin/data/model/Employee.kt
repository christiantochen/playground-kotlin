package com.christiantochen.learnkotlin.data.model

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    tableName = "users",
    primaryKeys = ["id"],
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["id"],
            childColumns = ["id"],
            onDelete = ForeignKey.NO_ACTION)
    ]
)
data class Employee(
    var id: Int,
    var nip: String? = null,
    var full_name: String? = null,
    var position_name: String? = null,
    var display_image: String? = null
)