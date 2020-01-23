package com.salvaperez.postbox.ui.home

import com.salvaperez.postbox.ui.view_model.PostDataViewModel

interface PostView {

    fun initViews()

    fun showLoading()

    fun hideLoading()

    fun showEmpty()

    fun showData(post: List<PostDataViewModel>)

    fun openDetail(post: PostDataViewModel)
}