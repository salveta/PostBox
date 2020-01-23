package com.salvaperez.postbox.data.data_sources

import com.salvaperez.data.source.RemotePostDataSource
import com.salvaperez.domain.Post
import com.salvaperez.postbox.data.entities.toDomain
import com.salvaperez.postbox.data.server.PostBoxDb

class PostDataSource: RemotePostDataSource{

    override suspend fun getPostList(): List<Post> =
        PostBoxDb.service
            .getContactsAsync()
            .await().map { it.toDomain() }
}