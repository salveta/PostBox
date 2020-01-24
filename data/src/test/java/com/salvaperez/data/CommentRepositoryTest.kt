package com.salvaperez.data

import com.nhaarman.mockitokotlin2.whenever
import com.salvaperez.data.repository.CommentRepository
import com.salvaperez.data.source.RemoteCommentDataSource
import com.salvaperez.domain.Comment
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CommentRepositoryTest {


    @Mock
    lateinit var remoteCommentDataSource: RemoteCommentDataSource
    lateinit var commenRepository: CommentRepository


    @Before
    fun setUp() {
        commenRepository = CommentRepository(remoteCommentDataSource)
    }

    @Test
    fun `getComments give you the comment list`() {
        runBlocking {

            val remoteComments = listOf(mochedComment.copy("body"))
            whenever(remoteCommentDataSource.getComments()).thenReturn(remoteComments)

            val comments = commenRepository.getComments()

            Assert.assertEquals(comments, remoteComments)
        }
    }


    private val mochedComment = Comment(
        "body",
        "email",
        2,
        "name",
        1
    )
}