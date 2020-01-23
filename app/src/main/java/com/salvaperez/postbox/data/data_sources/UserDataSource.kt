package com.salvaperez.postbox.data.data_sources

import com.salvaperez.data.source.RemoteUserDataSource
import com.salvaperez.domain.User
import com.salvaperez.postbox.data.entities.toDomain
import com.salvaperez.postbox.data.server.PostBoxDb

class UserDataSource: RemoteUserDataSource{

    override suspend fun getUserList(): List<User> =
        PostBoxDb.service
            .getUsersAsync()
            .await()
            .map { it.toDomain() }

}