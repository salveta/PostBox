package com.salvaperez.postbox.data.entities

import com.salvaperez.domain.Post
import com.salvaperez.postbox.data.entities.PostEntity

fun PostEntity.toDomain(): Post =
    Post(
        body = body,
        id = id,
        title = title,
        userId = userId
    )