package com.salvaperez.postbox.ui.view_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PostDataViewModel(val body: String,
                    val id: Int,
                    val title: String, val user: UserViewModel, val comment: List<CommentViewModel>): Parcelable