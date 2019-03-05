package com.christiantochen.learnkotlin.ui.main

import androidx.lifecycle.MutableLiveData
import com.christiantochen.learnkotlin.BaseViewModel
import com.christiantochen.learnkotlin.model.DOCUMENT_TYPE
import com.christiantochen.learnkotlin.model.TASK_STATUS
import com.christiantochen.learnkotlin.model.Task
import com.christiantochen.learnkotlin.model.User
import io.reactivex.disposables.Disposable
import java.util.*

class MainViewModel :
    BaseViewModel()
{
    private lateinit var subscription: Disposable

    val user: MutableLiveData<User> = MutableLiveData()

    init {
        user.value = User(id = 1,
            full_name = "Aan Darmawan",
            role_name = "VMI Officer",
            display_image = "https://cdn1.iconfinder.com/data/icons/business-users/512/circle-512.png",
            tasks = listOf(
                    Task(task_date = Calendar.getInstance().time, document_type = DOCUMENT_TYPE.INTERNAL, quantity = 10000, task_status = TASK_STATUS.COMPLETED),
                    Task(task_date = Calendar.getInstance().time, document_type = DOCUMENT_TYPE.INTERNAL, quantity = 10000),
                    Task(task_date = Calendar.getInstance().time, document_type = DOCUMENT_TYPE.INTERNAL, quantity = 10000)
                )
            )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}