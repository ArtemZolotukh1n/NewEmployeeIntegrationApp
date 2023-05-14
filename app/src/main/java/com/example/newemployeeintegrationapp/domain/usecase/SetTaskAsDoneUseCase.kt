package com.example.newemployeeintegrationapp.domain.usecase

import com.example.newemployeeintegrationapp.data.database.TaskDao
import com.example.newemployeeintegrationapp.data.repository.TaskRepository
import javax.inject.Inject

class SetTaskAsDoneUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskId: Int) {
        taskRepository.setTaskAsDone(taskId)
    }
}