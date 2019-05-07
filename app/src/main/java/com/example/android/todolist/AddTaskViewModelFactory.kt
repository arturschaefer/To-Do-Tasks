package com.example.android.todolist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.android.todolist.database.AppDatabase

class AddTaskViewModelFactory(val application: Application,
                              private val mTaskId: Int) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddTaskViewModel(application, mTaskId) as T
    }
}
