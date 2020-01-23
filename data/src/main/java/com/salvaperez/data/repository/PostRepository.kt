package com.salvaperez.data.repository

import com.salvaperez.data.source.RemotePostDataSource
import com.salvaperez.domain.Post

class PostRepository(private val remotePostDataSource: RemotePostDataSource) {

    suspend fun getPosts(): List<Post>{
        return remotePostDataSource.getPostList()
    }
}