package com.salvaperez.data

import com.nhaarman.mockitokotlin2.whenever
import com.salvaperez.data.repository.PostRepository
import com.salvaperez.data.source.RemotePostDataSource
import com.salvaperez.domain.Post
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesRepositoryTest {


    @Mock
    lateinit var remotePostDataSource: RemotePostDataSource
    lateinit var postRepository: PostRepository


    @Before
    fun setUp() {
        postRepository = PostRepository(remotePostDataSource)
    }

    @Test
    fun `getPost give you the post list`() {
        runBlocking {

            val remotePost = listOf(mockedPost.copy("this is a body post"))
            whenever(remotePostDataSource.getPostList()).thenReturn(remotePost)

            val post = postRepository.getPosts()

            Assert.assertEquals(post, remotePost)
        }
    }


    private val mockedPost = Post(
    "this is a body post",
    3,
    "this is title post",
    1
    )
}