package com.salvaperez.domain


data class PostData(val body: String,
                    val id: Int,
                    val title: String, val user: User, val comments: List<Comment>)