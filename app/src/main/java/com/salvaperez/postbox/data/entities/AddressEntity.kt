package com.salvaperez.postbox.data.entities

import com.google.gson.annotations.SerializedName


data class AddressEntity(
    @SerializedName("city") val city: String,
    @SerializedName("geo") val geo: GeoEntity,
    @SerializedName("street") val street: String,
    @SerializedName("suite") val suite: String,
    @SerializedName("zipcode") val zipcode: String
)