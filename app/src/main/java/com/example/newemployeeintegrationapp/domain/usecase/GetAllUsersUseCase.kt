package com.example.newemployeeintegrationapp.domain.usecase

import com.example.newemployeeintegrationapp.data.repository.UserRepository
import com.example.newemployeeintegrationapp.domain.model.User
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun execute(): List<User> {
        return userRepository.getAllUsers()
    }
}