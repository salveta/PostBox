package com.salvaperez.postbox.data.entities

import com.google.gson.annotations.SerializedName

data class PostEntity(@SerializedName("body") val body: String,
                      @SerializedName("id") val id: Int,
                      @SerializedName("title") val title: String,
                      @SerializedName("userId") val userId: Int)