package com.salvaperez.data.repository

import com.salvaperez.data.source.RemoteCommentDataSource
import com.salvaperez.domain.Comment

class CommentRepository(private val remotePostDataSource: RemoteCommentDataSource) {

    suspend fun getComments(): List<Comment>{
        return remotePostDataSource.getComments()
    }
}