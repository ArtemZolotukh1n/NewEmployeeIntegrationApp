package com.example.newemployeeintegrationapp.domain.usecase

import com.example.newemployeeintegrationapp.data.database.TaskEntity
import com.example.newemployeeintegrationapp.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    fun execute(): Flow<List<TaskEntity>> {
        return taskRepository.getTasks()
    }
}