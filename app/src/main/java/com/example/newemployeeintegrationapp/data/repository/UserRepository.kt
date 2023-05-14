package com.example.newemployeeintegrationapp.data.repository

import com.example.newemployeeintegrationapp.data.database.UserDao
import com.example.newemployeeintegrationapp.data.mappers.toDomainModel
import com.example.newemployeeintegrationapp.domain.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers().map { it.toDomainModel() }
    }
}