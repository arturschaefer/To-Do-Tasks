package com.example.android.todolist.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert

class TaskRepository (private val dao: TaskDao) {
    val allTasks: LiveData<List<TaskEntry>> = dao.loadAllTasks()

    @WorkerThread
    fun insertTask(task: TaskEntry) {
        dao.insertTask(task)
    }

    @WorkerThread
    fun deleteTask(task: TaskEntry) {
        dao.deleteTask(task)
    }

    @WorkerThread
    fun loadTaskById(taskId: Int): LiveData<TaskEntry> {
        return dao.loadTaskById(taskId)
    }

}