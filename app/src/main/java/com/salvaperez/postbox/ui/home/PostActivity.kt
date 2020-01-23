package com.salvaperez.postbox.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.salvaperez.postbox.R
import com.salvaperez.domain.PostData
import com.salvaperez.postbox.ui.extensions.gone
import com.salvaperez.postbox.ui.extensions.visible
import com.salvaperez.postbox.ui.home.adapter.PostAdapter
import kotlinx.android.synthetic.main.activity_posts.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PostActivity : AppCompatActivity(), PostView {

    private val presenter: PostPresenter by inject { parametersOf(this) }
    private var postAdapter: PostAdapter? = null

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onStart() {
        presenter.onStart()
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        presenter.onInit()
    }

    override fun initViews() {
        postAdapter = PostAdapter()
        rvPosts.layoutManager = LinearLayoutManager(this)
        rvPosts.adapter = postAdapter
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.gone()
    }

    override fun showEmpty() {
        txEmptyText.visible()
    }

    override fun showData(post: List<PostData>) {
        postAdapter?.post = post
    }
}
