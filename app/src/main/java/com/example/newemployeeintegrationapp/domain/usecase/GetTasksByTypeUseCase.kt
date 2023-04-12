package com.example.newemployeeintegrationapp.domain.usecase

import com.example.newemployeeintegrationapp.data.repository.TaskRepository
import com.example.newemployeeintegrationapp.domain.model.Task
import javax.inject.Inject

class GetTasksByTypeUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    suspend fun execute(taskType: String): List<Task> {
        return taskRepository.getTasksByType(taskType)
    }
}