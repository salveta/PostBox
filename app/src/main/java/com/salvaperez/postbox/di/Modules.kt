package com.salvaperez.postbox.di

import android.app.Application
import com.salvaperez.data.repository.CommentRepository
import com.salvaperez.data.repository.PostRepository
import com.salvaperez.data.repository.UserRepository
import com.salvaperez.data.source.RemoteCommentDataSource
import com.salvaperez.data.source.RemotePostDataSource
import com.salvaperez.data.source.RemoteUserDataSource
import com.salvaperez.postbox.BuildConfig
import com.salvaperez.postbox.data.data_sources.PostDataSource
import com.salvaperez.postbox.data.data_sources.UserDataSource
import com.salvaperez.postbox.data.data_sources.CommentDataSource
import com.salvaperez.postbox.ui.detail.DetailPresenter
import com.salvaperez.postbox.ui.detail.DetailView
import com.salvaperez.postbox.ui.home.PostPresenter
import com.salvaperez.postbox.ui.home.PostView
import com.salvaperez.usecases.GetComments
import com.salvaperez.usecases.GetPosts
import com.salvaperez.usecases.GetUsers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun Application.initKoin() {
    startKoin {
        androidLogger()
        androidContext(this@initKoin)
        modules(listOf(appModule, dataModule, postsModule))
    }
}

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
    factory { (view: DetailView) -> DetailPresenter(view) }
    factory { (view: PostView) -> PostPresenter(view, get(), get(), get()) }
    factory { GetPosts(get()) }
    factory { GetUsers(get()) }
    factory { GetComments(get()) }
}