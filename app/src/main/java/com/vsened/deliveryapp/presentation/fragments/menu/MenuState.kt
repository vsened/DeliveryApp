package com.vsened.deliveryapp.presentation.fragments.menu

import com.vsened.deliveryapp.domain.model.FoodType
import com.vsened.deliveryapp.domain.model.Meal

data class MenuState(
    val meals: List<Meal> = emptyList(),
    val types: List<FoodType> = emptyList(),
    val isLoading: Boolean = false,
    val selectTypeIndex: Int = 0

)