package com.example.newemployeeintegrationapp.data.repository

import com.example.newemployeeintegrationapp.data.database.TaskDao
import com.example.newemployeeintegrationapp.data.mappers.toDomainModel
import com.example.newemployeeintegrationapp.domain.model.Task
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {
    fun getTasks(): Flow<List<Task>> {
        return taskDao.getAllTasksAsFlow().map { taskEntities ->
            taskEntities.map { it.toDomainModel() }
        }
    }

}