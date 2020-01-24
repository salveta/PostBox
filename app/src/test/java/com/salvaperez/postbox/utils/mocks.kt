package com.salvaperez.postbox.utils

import com.salvaperez.domain.*
import com.salvaperez.postbox.ui.view_model.CommentViewModel
import com.salvaperez.postbox.ui.view_model.PostDataViewModel
import com.salvaperez.postbox.ui.view_model.UserViewModel

internal val mockedPost = Post(
"this is a body post",
    1,
    "this is title post",
    1
)

internal val mochedUser = User(
    Address("city", Geo("lat", "long"), "street", "suite", "zipcode"),
    Company("bs", "catchPhrase", "name"),
    "email",
    2,
    "email",
"6484948494",
    "bob spencer",
    "www.mywebsite.com"
)

internal val mockedComment = Comment(
    "bob",
    "email",
    2,
    "name",
1
)

internal val mockedPostDataViewModel = PostDataViewModel(
    "this is a body post",
    1,
    "this is title post",
    UserViewModel("email", 1, "email", "bob spencer"),
    ComentViewModel()
)

private fun ComentViewModel(): List<CommentViewModel>{
    val comment = CommentViewModel(1)
    return listOf<CommentViewModel>(comment)
}