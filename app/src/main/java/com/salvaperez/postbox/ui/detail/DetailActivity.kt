package com.salvaperez.postbox.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.salvaperez.postbox.R
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

    override fun initView(post: PostDataViewModel?) {
        txPostTitleDetail.text = post?.title?.capitalize()
        txUserName.text = post?.user?.name
        txCommentsNumber.text = post?.body?.length.toString()
        txBody.text = post?.body
    }

    companion object{
        const val DETAIL = "DetailActivity"
    }
}