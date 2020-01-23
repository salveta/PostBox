package com.salvaperez.postbox.data.data_sources

import com.salvaperez.data.source.RemoteCommentDataSource
import com.salvaperez.domain.Comment
import com.salvaperez.postbox.data.entities.toDomain
import com.salvaperez.postbox.data.server.PostBoxDb

class CommentDataSource: RemoteCommentDataSource {

    override suspend fun getComments(): List<Comment> =
        PostBoxDb.service
            .getCommentAsync()
            .await().map { it.toDomain() }
}