package com.salvaperez.postbox.data.entities

import com.salvaperez.domain.Comment

fun CommentEntity.toDomain(): Comment =
    Comment(
        body = body,
        email = email,
        id = id,
        name = name,
        postId = postId
    )