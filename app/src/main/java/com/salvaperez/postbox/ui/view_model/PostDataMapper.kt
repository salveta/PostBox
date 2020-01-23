package com.salvaperez.postbox.ui.view_model

import com.salvaperez.domain.Comment
import com.salvaperez.domain.PostData
import com.salvaperez.domain.User

fun PostData.toViewModel(): PostDataViewModel =
    PostDataViewModel(
        body = body,
        id = id,
        title = title,
        user = user.toViewModel(),
        comment = comments.map { it.toViewModel() }
    )

fun Comment.toViewModel(): CommentViewModel =
    CommentViewModel(
        id = id
    )

fun User.toViewModel(): UserViewModel =
    UserViewModel(
        email = email,
        id = id,
        name = name,
        username = username
    )
