package com.salvaperez.postbox

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.verify
import com.salvaperez.postbox.ui.detail.DetailPresenter
import com.salvaperez.postbox.ui.detail.DetailView
import com.salvaperez.postbox.utils.mockedPostDataViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailPresenterTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var view: DetailView

    private lateinit var presenter: DetailPresenter

    @Before
    fun setUp() {
        presenter = DetailPresenter(view)
    }


    @Test
    fun `onInit show detail data`() {

        val postDataViewModel = mockedPostDataViewModel.copy()

        presenter.onInit(postDataViewModel)
        verify(view).initViews(postDataViewModel)
    }
}