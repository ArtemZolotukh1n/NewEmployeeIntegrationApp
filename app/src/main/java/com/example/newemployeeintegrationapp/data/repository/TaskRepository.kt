package com.example.newemployeeintegrationapp.data.repository

import com.example.newemployeeintegrationapp.data.database.TaskDao
import com.example.newemployeeintegrationapp.data.database.TaskEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {
    fun getTasks(): Flow<List<TaskEntity>> {
        return taskDao.getAllTasksAsFlow()
    }

}