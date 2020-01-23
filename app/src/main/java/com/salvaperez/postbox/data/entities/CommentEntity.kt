package com.salvaperez.postbox.data.entities

import com.google.gson.annotations.SerializedName

data class CommentEntity(
    @SerializedName("body") val body: String,
    @SerializedName("email") val email: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("postId") val postId: Int
)