package com.salvaperez.postbox.ui.home

import com.salvaperez.domain.Comment
import com.salvaperez.domain.Post
import com.salvaperez.domain.User
import com.salvaperez.domain.PostData
import com.salvaperez.postbox.ui.common.Scope
import com.salvaperez.usecases.GetComments
import com.salvaperez.usecases.GetPosts
import com.salvaperez.usecases.GetUsers
import kotlinx.coroutines.async


class PostPresenter(private var view: PostView? = null, private val getUsers: GetUsers, private val getPosts: GetPosts, private val getComments: GetComments): Scope by Scope.Impl(){

    fun onStart(){
        initScope()

        async {
            view?.showLoading()
            val post = getPosts()
            val users = getUsers()
            val comments = getComments()

            updateData(users, post, comments)
            view?.hideLoading()
        }
    }

    fun onInit(){
        view?.initViews()
    }

    private fun updateData(users: List<User>, post: List<Post>, comments: List<Comment>){

        if(post.isNotEmpty()){
            view?.showData(createPostData(users, post, comments))

        }else{
            view?.showEmpty()
        }
    }

    private fun createPostData(users: List<User>, post: List<Post>, comments: List<Comment>): List<PostData>{
        return post.fold(ArrayList<PostData>()) { joinedPosts, post ->
            val postComments = comments.filter { it.postId == post.id }
            val user = users.first { it.id == post.userId }

            joinedPosts.add(
                PostData(
                    post.body,
                    post.id,
                    post.title,
                    user,
                    postComments
                )
            )
            joinedPosts
        }.toList()
    }


    fun onDestroy() {
        view = null
        destroyScope()
    }
}