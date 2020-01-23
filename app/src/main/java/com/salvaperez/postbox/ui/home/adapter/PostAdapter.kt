package com.salvaperez.postbox.ui.home.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvaperez.postbox.R
import com.salvaperez.domain.PostData
import com.salvaperez.postbox.ui.extensions.basicDiffUtil
import com.salvaperez.postbox.ui.extensions.inflate
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter: RecyclerView.Adapter<PostAdapter.ViewHolder>(){

    var post: List<PostData> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new ->
            old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_post, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return post.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = post[position]
        holder.bind(post, position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: PostData, position: Int) {
            itemView.txPostTitle.text = post.title.capitalize()
            itemView.txPostDescription.text = post.body
        }
    }
}