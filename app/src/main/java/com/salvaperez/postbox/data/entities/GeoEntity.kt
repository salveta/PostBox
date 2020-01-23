package com.salvaperez.postbox.data.entities

import com.google.gson.annotations.SerializedName

data class GeoEntity(
    @SerializedName("lat") val lat: String,
    @SerializedName("lng") val lng: String
)