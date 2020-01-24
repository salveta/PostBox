package com.salvaperez.postbox

import android.content.Context
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.salvaperez.postbox.di.postsModule
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
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.parameter.parametersOf
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostPresenterTest: KoinTest {

    private val context: Context = mock()
    private val view: PostView = mock()
    private val presenter: PostPresenter by inject { parametersOf(view) }

    @Before
    fun setUp() {
        startKoin {
            androidContext(context)
            modules(postsModule)
        }
        declareMock<GetUsers>()
        declareMock<GetPosts>()
        declareMock<GetComments>()
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

    @After
    fun after() {
        stopKoin()
    }
}