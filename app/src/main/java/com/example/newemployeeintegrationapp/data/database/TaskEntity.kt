package com.example.newemployeeintegrationapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "tasks")
data class TaskEntity(

    @PrimaryKey
    val id: Int,

    @NotNull
    val task: String,

    @NotNull
    val description: String,

    @NotNull
    val taskType: String,

    @NotNull
    val isDone: Int
)