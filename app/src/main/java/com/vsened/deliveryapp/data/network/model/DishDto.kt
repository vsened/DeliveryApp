package com.vsened.deliveryapp.data.network.model


import com.google.gson.annotations.SerializedName

data class DishDto(
    @SerializedName("meals")
    val meals: List<MealDto>
)