package com.salvaperez.postbox.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.espresso.IdlingResource
import com.salvaperez.postbox.R
import com.salvaperez.postbox.idlingResources.SimpleIdlingResource
import com.salvaperez.postbox.idlingResources.decrementIdlingResource
import com.salvaperez.postbox.idlingResources.incrementIdlingResource
import com.salvaperez.postbox.ui.detail.DetailActivity
import com.salvaperez.postbox.ui.extensions.gone
import com.salvaperez.postbox.ui.extensions.open
import com.salvaperez.postbox.ui.extensions.visible
import com.salvaperez.postbox.ui.home.adapter.PostAdapter
import com.salvaperez.postbox.ui.view_model.PostDataViewModel
import kotlinx.android.synthetic.main.activity_posts.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PostActivity : AppCompatActivity(), PostView {

    private val presenter: PostPresenter by inject { parametersOf(this) }
    private var postAdapter: PostAdapter? = null

    @Nullable
    var mIdlingResource: SimpleIdlingResource = SimpleIdlingResource()

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
        postAdapter = PostAdapter{ post ->
            presenter.onPostclick(post)
        }

        rvPosts.layoutManager = LinearLayoutManager(this)
        rvPosts.adapter = postAdapter
    }

    override fun openDetail(post: PostDataViewModel) {
        val extras = Bundle()
        extras.putParcelable(DetailActivity.DETAIL, post)
        open(DetailActivity::class.java, extras)
    }

    override fun showLoading() {
        progressBar.visible()
        incrementIdlingResource(mIdlingResource)
    }

    override fun hideLoading() {
        progressBar.gone()
        decrementIdlingResource()
    }

    override fun showEmpty() {
        txEmptyText.visible()
    }

    override fun showData(post: List<PostDataViewModel>) {
        postAdapter?.post = post
    }

    @VisibleForTesting
    fun getIdlingResource(): IdlingResource {
        return mIdlingResource
    }
}
