package com.schaefer.android.todolist.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class AddTaskViewModelFactory(private val mApplication: Application, private val mParam: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddTaskViewModel(mApplication, mParam) as T
    }
}