package com.example.android.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import android.util.Log
import androidx.lifecycle.viewModelScope

import com.example.android.todolist.database.AppDatabase
import com.example.android.todolist.database.TaskEntry
import com.example.android.todolist.database.TaskRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var repository: TaskRepository
    val allTasks: LiveData<List<TaskEntry>>

    init {
        val taskDao = AppDatabase.getDatabase(application, viewModelScope).taskDao()
        Log.d(TAG, "Actively retrieving the tasks from the DataBase")
        repository = TaskRepository(taskDao)
        allTasks = repository.allTasks
    }

    companion object {
        // Constant for logging
        private val TAG = MainViewModel::class.java.simpleName
    }
}
