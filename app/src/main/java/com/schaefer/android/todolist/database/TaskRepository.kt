package com.schaefer.android.todolist.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

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


    @WorkerThread
    fun updateTask(task: TaskEntry) {
        dao.updateTask(task)
    }

}