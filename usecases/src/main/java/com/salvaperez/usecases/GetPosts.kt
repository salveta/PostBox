package com.salvaperez.usecases

import com.salvaperez.data.repository.PostRepository
import com.salvaperez.domain.Post

class GetPosts(private val postRepository: PostRepository) {
    suspend operator fun invoke(): List<Post>{
        return postRepository.getPosts()
    }
}