package com.schaefer.android.todolist.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import com.schaefer.android.todolist.database.AppDatabase
import com.schaefer.android.todolist.database.TaskEntry
import com.schaefer.android.todolist.database.TaskRepository

class AddTaskViewModel(application: Application, taskId: Int) : AndroidViewModel(application) {
    val task: LiveData<TaskEntry>
    var repository: TaskRepository

    init {
        val taskDao = AppDatabase.getDatabase(application, viewModelScope).taskDao()
        Log.d(TAG, "Actively retrieving the tasks from the DataBase")
        repository = TaskRepository(taskDao)
        task = repository.loadTaskById(taskId)
    }

    companion object {
        // Constant for logging
        private val TAG = AddTaskViewModel::class.java.simpleName
    }
}
