package com.example.newemployeeintegrationapp.domain.model


data class User(
    val userId: Long,
    val name: String,
    val surname: String,
    val nickname: String,
    val completionPercentage: Double
)
