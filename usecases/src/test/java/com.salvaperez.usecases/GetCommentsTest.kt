package com.salvaperez.usecases

import com.nhaarman.mockitokotlin2.whenever
import com.salvaperez.data.repository.CommentRepository
import com.salvaperez.usecases.utils.mochedComment
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCommentsTest {

    @Mock
    lateinit var commentRepository: CommentRepository

    lateinit var getComments: GetComments

    @Before
    fun setUp() {
        getComments = GetComments(commentRepository)
    }

    @Test
    fun `invoke calls comments repository`() {
        runBlocking {

            val comment = listOf(mochedComment.copy())
            whenever(commentRepository.getComments()).thenReturn(comment)

            val result = getComments.invoke()

            Assert.assertEquals(comment, result)
        }
    }
}