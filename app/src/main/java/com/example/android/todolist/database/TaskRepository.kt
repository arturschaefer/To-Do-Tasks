package com.example.android.todolist.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class TaskRepository (private val dao: TaskDao) {
    val allTasks: LiveData<List<TaskEntry>> = dao.loadAllTasks()

    @WorkerThread
    suspend fun insert(task: TaskEntry) {
        dao.insertTask(task)
    }

}