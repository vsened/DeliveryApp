package com.vsened.deliveryapp.data.network.model


import com.google.gson.annotations.SerializedName

data class FoodTypeDto(
    @SerializedName("strCategory")
    val strCategory: String
)