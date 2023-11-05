package com.vsened.deliveryapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodTypeEntity(
    val strCategory: String,
    @PrimaryKey val id: Int? = null
)

