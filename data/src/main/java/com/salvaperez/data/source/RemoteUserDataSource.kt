package com.salvaperez.data.source

import com.salvaperez.domain.User

interface RemoteUserDataSource {

    suspend fun getUserList(): List<User>

}