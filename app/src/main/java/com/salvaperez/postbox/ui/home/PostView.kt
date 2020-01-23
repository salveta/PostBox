package com.salvaperez.postbox.ui.home

import com.salvaperez.domain.PostData

interface PostView {

    fun initViews()

    fun showLoading()

    fun hideLoading()

    fun showEmpty()

    fun showData(post: List<PostData>)
}