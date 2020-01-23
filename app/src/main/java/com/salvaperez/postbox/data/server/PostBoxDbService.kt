package com.salvaperez.postbox.data.server

import com.salvaperez.postbox.data.entities.CommentEntity
import com.salvaperez.postbox.data.entities.PostEntity
import com.salvaperez.postbox.data.entities.UserEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PostBoxDbService{

    @GET("/posts")
    fun getContactsAsync(): Deferred<List<PostEntity>>

    @GET("/users")
    fun getUsersAsync(): Deferred<List<UserEntity>>

    @GET("/comments")
    fun getCommentAsync(): Deferred<List<CommentEntity>>
}