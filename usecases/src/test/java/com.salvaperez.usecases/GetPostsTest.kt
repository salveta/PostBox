package com.salvaperez.usecases

import com.nhaarman.mockitokotlin2.whenever
import com.salvaperez.data.repository.PostRepository
import com.salvaperez.usecases.utils.mockedPost
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetPostsTest {

    @Mock
    lateinit var postRepository: PostRepository

    lateinit var getPosts: GetPosts

    @Before
    fun setUp() {
        getPosts = GetPosts(postRepository)
    }

    @Test
    fun `invoke calls posts repository`() {
        runBlocking {

            val posts = listOf(mockedPost.copy())
            whenever(postRepository.getPosts()).thenReturn(posts)

            val result = getPosts.invoke()

            Assert.assertEquals(posts, result)
        }
    }
}