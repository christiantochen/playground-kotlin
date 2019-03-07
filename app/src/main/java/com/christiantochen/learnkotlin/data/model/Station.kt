package com.christiantochen.learnkotlin.data.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "stations",
    primaryKeys = ["id"],
    foreignKeys = [
        ForeignKey(entity = Area::class,
            parentColumns = ["id"],
            childColumns = ["area_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Station(
    val id: Int,
    val name: String,
    val display_name: String,
    //
    val area_id: Int
)