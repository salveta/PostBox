package com.salvaperez.domain

import com.salvaperez.domain.Comment
import com.salvaperez.domain.User

data class PostData(val body: String,
                    val id: Int,
                    val title: String, val user: User, val comments: List<Comment>)