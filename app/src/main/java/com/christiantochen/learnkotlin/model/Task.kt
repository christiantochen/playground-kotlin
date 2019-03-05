package com.christiantochen.learnkotlin.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = [ForeignKey(
    entity = User::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("user_id"),
    onDelete = ForeignKey.CASCADE
)])
data class Task(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val task_date: Date,
    val document_type: DOCUMENT_TYPE,
    val quantity: Int,
    // nullable for later PICKUP features
    var user_id: Int? = null,
    // input by VMI
    var task_status: TASK_STATUS = TASK_STATUS.OPEN,
    var actual_start_datetime: Date? = null,
    var actual_end_datetime: Date? = null,
    var fuel_meter_start: String? = null,
    var fuel_meter_end: String? = null,
    var gross_quantity: Int? = null
)

enum class DOCUMENT_TYPE {
    INTERNAL,
    EXTERNAL
}

enum class TASK_STATUS {
    OPEN,
    IN_PROGRESS,
    COMPLETED
}