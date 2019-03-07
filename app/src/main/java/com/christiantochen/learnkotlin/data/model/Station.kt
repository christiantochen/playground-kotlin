package com.christiantochen.learnkotlin.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Area::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("area_id"),
    onDelete = ForeignKey.NO_ACTION)]
)
data class Station(
    @PrimaryKey
    val id: Int,
    val name: String,
    val display_name: String,
    //
    val area_id: Int
)