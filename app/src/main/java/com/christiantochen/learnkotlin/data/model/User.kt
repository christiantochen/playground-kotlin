package com.christiantochen.learnkotlin.data.model

import androidx.room.*

@Entity(
    tableName = "users",
    primaryKeys = ["id"],
    foreignKeys = [
        ForeignKey(entity = Area::class,
            parentColumns = ["id"],
            childColumns = ["area_id"],
            onDelete = ForeignKey.NO_ACTION),
        ForeignKey(entity = Role::class,
            parentColumns = ["id"],
            childColumns = ["role_id"],
            onDelete = ForeignKey.NO_ACTION),
        ForeignKey(entity = Station::class,
            parentColumns = ["id"],
            childColumns = ["station_id"],
            onDelete = ForeignKey.NO_ACTION)
    ]
)
data class User(
    var id: Int,
    var email: String? = null,
    var phone_number: String? = null,
    // Foreigns
    var area_id: Int? = null,
    var role_id: Int? = null,
    var station_id: Int? = null,
    // Relations
    @Relation(parentColumn = "id", entityColumn = "id", entity = Employee::class)
    var employee: Employee,
    @Relation(parentColumn = "id", entityColumn = "user_id", entity = Task::class)
    var tasks: List<Task>
) {
    @Ignore var task_completed: Int = tasks.filter { it.task_status == TaskStatus.COMPLETED }.count()
    @Ignore var task_count: Int = tasks.count()
    @Ignore var task_current: Int = task_count - task_completed
    @Ignore var task_progress: String = (task_completed * 100 / task_count).toString() + "%"
    @Ignore var has_task: Boolean = task_current > 0
}