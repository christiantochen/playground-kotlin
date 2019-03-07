package com.christiantochen.learnkotlin.ui.dashboard

import androidx.lifecycle.MutableLiveData
import com.christiantochen.learnkotlin.BaseViewModel
import com.christiantochen.learnkotlin.data.model.Employee
import com.christiantochen.learnkotlin.data.model.Task
import com.christiantochen.learnkotlin.data.model.TaskStatus
import com.christiantochen.learnkotlin.data.model.User
import io.reactivex.disposables.Disposable
import java.util.*

class DashboardViewModel :
    BaseViewModel()
{
    private lateinit var subscription: Disposable

    val user: MutableLiveData<User> = MutableLiveData()

    init {
        user.value = User(
            id = 1,
            employee = Employee(
                id = 1,
                full_name = "Aan Darmawan",
                position_name = "VMI Officer",
                display_image = "https://cdn1.iconfinder.com/data/icons/business-users/512/circle-512.png"
            ),
            tasks = listOf(
                Task(
                    task_date = Calendar.getInstance().time,
                    quantity = 10000,
                    task_status = TaskStatus.COMPLETED
                ),
                Task(
                    task_date = Calendar.getInstance().time,
                    quantity = 10000
                ),
                Task(
                    task_date = Calendar.getInstance().time,
                    quantity = 10000
                )
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}