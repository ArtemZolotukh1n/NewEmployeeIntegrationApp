package com.example.newemployeeintegrationapp.data.repository

import com.example.newemployeeintegrationapp.data.database.TaskDao
import com.example.newemployeeintegrationapp.data.mappers.toDomainModel
import com.example.newemployeeintegrationapp.data.mappers.toEntityModel
import com.example.newemployeeintegrationapp.domain.model.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {
    suspend fun getTasks(): List<Task> {
        return taskDao.getAllTasks().map {
            it.toDomainModel()
        }
    }

    suspend fun getTasksByType(taskType: String): List<Task> {
        return taskDao.getTasksByType(taskType).map { it.toDomainModel() }
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task.toEntityModel())
    }

    suspend fun setTaskAsDone(taskId: Int) {
        taskDao.setTaskAsDone(taskId)
    }
}