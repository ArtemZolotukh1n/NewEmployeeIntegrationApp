package com.example.newemployeeintegrationapp.domain.usecase

import com.example.newemployeeintegrationapp.data.repository.TaskRepository
import com.example.newemployeeintegrationapp.domain.model.Task
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    suspend fun execute(task: Task) {
        taskRepository.deleteTask(task)
    }
}