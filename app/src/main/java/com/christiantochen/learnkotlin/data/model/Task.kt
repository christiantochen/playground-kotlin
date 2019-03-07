package com.christiantochen.learnkotlin.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import java.util.*

@Entity(
    tableName = "roles",
    primaryKeys = ["id"],
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Task(
    val id: UUID = UUID.randomUUID(),
    val task_date: Date,
    val quantity: Int,
    // nullable for later PICKUP features
    var user_id: Int? = null,
    // input by VMI
    var task_status: TaskStatus = TaskStatus.OPEN,
    var actual_start_datetime: Date? = null,
    var actual_end_datetime: Date? = null,
    var fuel_meter_start: String? = null,
    var fuel_meter_end: String? = null,
    var gross_quantity: Int? = null
)