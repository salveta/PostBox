package com.salvaperez.postbox.ui.view_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserViewModel( val email: String,
                            val id: Int,
                            val name: String,
                            val username: String): Parcelable