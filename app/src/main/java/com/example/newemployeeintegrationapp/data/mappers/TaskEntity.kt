package com.example.newemployeeintegrationapp.data.mappers

import com.example.newemployeeintegrationapp.data.database.TaskEntity
import com.example.newemployeeintegrationapp.domain.model.Task

fun TaskEntity.toDomainModel(): Task {
    return Task(
        id = this.id,
        task = this.task,
        description = this.description,
        taskType = this.taskType
    )
}

fun Task.toEntityModel(): TaskEntity {
    return TaskEntity(
        id = this.id,
        task = this.task,
        description = this.description,
        taskType = this.taskType
    )
}