package com.salvaperez.postbox.ui.detail

import com.salvaperez.postbox.ui.view_model.PostDataViewModel
import kotlin.random.Random

class DetailPresenter(private var view: DetailView? = null){

    fun onInit(post: PostDataViewModel?){
        view?.initViews(post)
    }

    fun getRandomImage(): String{
        return Random.nextInt(0, 300).toString()
    }

    fun onDestroy(){
        view = null
    }
}