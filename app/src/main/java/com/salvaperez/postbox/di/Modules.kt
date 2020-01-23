package com.salvaperez.postbox.di

import com.salvaperez.data.repository.CommentRepository
import com.salvaperez.data.repository.PostRepository
import com.salvaperez.data.repository.UserRepository
import com.salvaperez.data.source.RemoteCommentDataSource
import com.salvaperez.data.source.RemotePostDataSource
import com.salvaperez.data.source.RemoteUserDataSource
import com.salvaperez.postbox.data.data_sources.PostDataSource
import com.salvaperez.postbox.data.data_sources.UserDataSource
import com.salvaperez.postbox.data.server.CommentDataSource
import com.salvaperez.postbox.ui.home.PostPresenter
import com.salvaperez.postbox.ui.home.PostView
import com.salvaperez.usecases.GetComments
import com.salvaperez.usecases.GetPosts
import com.salvaperez.usecases.GetUsers
import org.koin.dsl.module


val appModule = module {
    factory<RemotePostDataSource> { PostDataSource() }
    factory<RemoteUserDataSource> { UserDataSource() }
    factory<RemoteCommentDataSource> { CommentDataSource() }
}

val dataModule = module {
    factory { PostRepository(get()) }
    factory { UserRepository(get()) }
    factory { CommentRepository(get()) }
}

val postsModule = module(override = true) {
    factory { (view: PostView) -> PostPresenter(view, get(), get(), get()) }
    factory { GetPosts(get()) }
    factory { GetUsers(get()) }
    factory { GetComments(get()) }
}