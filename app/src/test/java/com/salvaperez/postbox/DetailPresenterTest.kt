package com.salvaperez.postbox

import android.content.Context
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.salvaperez.postbox.di.postsModule
import com.salvaperez.postbox.ui.detail.DetailPresenter
import com.salvaperez.postbox.ui.detail.DetailView
import com.salvaperez.postbox.utils.mockedPostDataViewModel
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
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailPresenterTest: KoinTest {

    private val context: Context = mock()
    private val view: DetailView = mock()
    private val presenter: DetailPresenter by inject { parametersOf(view) }

    @Before
    fun setUp() {
        startKoin {
            androidContext(context)
            modules(postsModule)
        }
    }


    @Test
    fun `onInit show detail data`() {

        val postDataViewModel = mockedPostDataViewModel.copy()

        presenter.onInit(postDataViewModel)
        verify(view).initViews(postDataViewModel)
    }

    @After
    fun after() {
        stopKoin()
    }
}