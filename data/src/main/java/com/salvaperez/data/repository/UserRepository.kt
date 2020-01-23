package com.salvaperez.data.repository

import com.salvaperez.data.source.RemoteUserDataSource
import com.salvaperez.domain.User

class UserRepository(private val remoteUserDataSource: RemoteUserDataSource) {

    suspend fun getUsers(): List<User>{
        return remoteUserDataSource.getUserList()
    }
}