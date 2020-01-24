package com.salvaperez.postbox.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.salvaperez.postbox.R
import com.salvaperez.postbox.ui.extensions.loadImage
import com.salvaperez.postbox.ui.view_model.PostDataViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class DetailActivity: AppCompatActivity(), DetailView{

    private val presenter: DetailPresenter by inject { parametersOf(this) }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter.onInit(intent?.getParcelableExtra(DETAIL))
    }

    override fun initViews(post: PostDataViewModel?) {
        txPostTitleDetail.text = post?.title?.capitalize()
        txUserName.text = post?.user?.name
        txCommentsNumber.text = post?.body?.length.toString()
        txBody.text = post?.body

        imPost.loadImage(IMAGE_URL + presenter.getRandomImage() + SIZE_IMAGE)
    }

    companion object{
        const val DETAIL = "DetailActivity"
        const val IMAGE_URL = "https://i.picsum.photos/id/"
        const val SIZE_IMAGE = "/800/800.jpg"
    }
}