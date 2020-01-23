package com.salvaperez.postbox.ui.detail

import com.salvaperez.postbox.ui.view_model.PostDataViewModel

interface DetailView {

    fun initView(post: PostDataViewModel?)
}