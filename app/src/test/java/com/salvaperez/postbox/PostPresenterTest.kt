package com.salvaperez.postbox

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.verify
import com.salvaperez.postbox.ui.home.PostPresenter
import com.salvaperez.postbox.ui.home.PostView
import com.salvaperez.postbox.utils.mochedUser
import com.salvaperez.postbox.utils.mockedComment
import com.salvaperez.postbox.utils.mockedPost
import com.salvaperez.postbox.utils.mockedPostDataViewModel
import com.salvaperez.usecases.GetComments
import com.salvaperez.usecases.GetPosts
import com.salvaperez.usecases.GetUsers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostPresenterTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getPosts: GetPosts

    @Mock
    lateinit var getUsers: GetUsers

    @Mock
    lateinit var getComments: GetComments

    private lateinit var presenter: PostPresenter

    @Mock
    lateinit var view: PostView

    @Before
    fun setUp() {
        presenter = PostPresenter(view, getUsers, getPosts, getComments)
    }

    @Test
    fun `Show empty text if post is empty`() {
        runBlocking {

            val users = listOf(mochedUser.copy(id = 1))
            presenter.updateData(users, emptyList(), emptyList())

            verify(view).showEmpty()
        }
    }

    @Test
    fun `Show data post if data is ready`() {
        runBlocking {

            val users = listOf(mochedUser.copy(id = 1))
            val post = listOf(mockedPost.copy(id = 1))
            val comments = listOf(mockedComment.copy(id = 1))
            val postDataViewModel = listOf(mockedPostDataViewModel.copy())

            presenter.updateData(users, post, comments)

            verify(view).showData(postDataViewModel)
        }
    }

    @Test
    fun `onInit show loading and call init views`() {
        presenter.onInit()

        verify(view).showLoading()
        verify(view).initViews()
    }

    @Test
    fun `onPostClick send post to detail activity`() {
        val postData = mockedPostDataViewModel.copy()

        presenter.onPostclick(postData)

        verify(view).openDetail(postData)
    }
}