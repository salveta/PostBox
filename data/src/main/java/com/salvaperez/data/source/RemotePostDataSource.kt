package com.salvaperez.data.source

import com.salvaperez.domain.Post

interface RemotePostDataSource {

    suspend fun getPostList(): List<Post>

}