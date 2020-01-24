package com.salvaperez.postbox.utils

import com.salvaperez.postbox.ui.view_model.CommentViewModel
import com.salvaperez.postbox.ui.view_model.PostDataViewModel
import com.salvaperez.postbox.ui.view_model.UserViewModel


fun mockedPostDataViewModel(): PostDataViewModel{
    return PostDataViewModel(
        "this is a body post",
        1,
        "this is title post",
        UserViewModel("email", 1, "email", "bob spencer"),
        ComentViewModel())
}

private fun ComentViewModel(): List<CommentViewModel>{
    val comment = CommentViewModel(1)
    return listOf<CommentViewModel>(comment)
}