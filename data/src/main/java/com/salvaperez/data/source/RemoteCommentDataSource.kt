package com.salvaperez.data.source

import com.salvaperez.domain.Comment

interface RemoteCommentDataSource {

    suspend fun getComments(): List<Comment>

}