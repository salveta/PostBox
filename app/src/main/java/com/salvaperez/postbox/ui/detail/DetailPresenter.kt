package com.salvaperez.postbox.ui.detail

import com.salvaperez.postbox.ui.view_model.PostDataViewModel

class DetailPresenter(private var view: DetailView? = null){

    fun onInit(post: PostDataViewModel?){
        view?.initViews(post)
    }

    fun onDestroy(){
        view = null
    }
}