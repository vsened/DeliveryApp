package com.vsened.deliveryapp.data.network.model


import com.google.gson.annotations.SerializedName

data class FoodTypesDto(
    @SerializedName("meals")
    val meals: List<FoodTypeDto>
)