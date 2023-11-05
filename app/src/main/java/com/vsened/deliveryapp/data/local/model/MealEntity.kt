package com.vsened.deliveryapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MealEntity(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    @PrimaryKey val id: Int? = null
)
