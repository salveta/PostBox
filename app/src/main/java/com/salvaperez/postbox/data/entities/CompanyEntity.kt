package com.salvaperez.postbox.data.entities

import com.google.gson.annotations.SerializedName

data class CompanyEntity(
    @SerializedName("bs") val bs: String,
    @SerializedName("catchPhrase") val catchPhrase: String,
    @SerializedName("name") val name: String
)