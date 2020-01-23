package com.salvaperez.usecases

import com.salvaperez.data.repository.UserRepository
import com.salvaperez.domain.User

class GetUsers(private val userRepository: UserRepository) {

    suspend operator fun invoke(): List<User>{
        return userRepository.getUsers()
    }
}