package com.example.newemployeeintegrationapp.data.mappers

import com.example.newemployeeintegrationapp.data.database.UserEntity
import com.example.newemployeeintegrationapp.domain.model.User

fun UserEntity.toDomainModel(): User {
    return User(
        userId = userId,
        name = name,
        surname = surname,
        nickname = nickname,
        completionPercentage = completionPercentage
    )
}