package com.salvaperez.postbox.data.entities

import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName("address") val address: AddressEntity,
    @SerializedName("company") val company: CompanyEntity,
    @SerializedName("email") val email: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("username") val username: String,
    @SerializedName("website") val website: String
)