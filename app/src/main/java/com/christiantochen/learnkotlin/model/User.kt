package com.christiantochen.learnkotlin.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class User(
    @PrimaryKey
    val id: Int,
    // User Info
    var email: String? = null,
    var phone_number: String? = null,
    // Role Info
    var role_name: String? = null,
    // Employee Info
    var nip: String? = null,
    var full_name: String? = null,
    var display_image: String? = null,
    // Task Relation
    @Relation(parentColumn = "id", entityColumn = "user_id", entity = Task::class)
    var tasks: List<Task>
) {
    @Ignore var task_completed: Int = tasks.filter { it.task_status == TASK_STATUS.COMPLETED }.count()
    @Ignore var task_count: Int = tasks.count()
    @Ignore var task_current: Int = task_count - task_completed
    @Ignore var task_progress: String = (task_completed * 100 / task_count).toString() + "%"
    @Ignore var has_task: Boolean = task_current > 0
}