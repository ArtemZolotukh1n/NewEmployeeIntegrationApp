package com.example.newemployeeintegrationapp.domain.model

data class Task(
    val id: Int,
    val task: String,
    val description: String,
    val taskType: String
)