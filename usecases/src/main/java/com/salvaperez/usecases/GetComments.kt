package com.salvaperez.usecases

import com.salvaperez.data.repository.CommentRepository
import com.salvaperez.domain.Comment

class GetComments(private val commentRepository: CommentRepository) {

    suspend operator fun invoke(): List<Comment>{
        return commentRepository.getComments()
    }
}