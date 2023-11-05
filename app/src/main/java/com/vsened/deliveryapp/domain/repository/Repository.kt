package com.vsened.deliveryapp.domain.repository

import com.vsened.deliveryapp.domain.model.FoodType
import com.vsened.deliveryapp.domain.model.Meal
import com.vsened.deliveryapp.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow


interface Repository {
    suspend fun getDishes(query: String): Flow<Resource<List<Meal>>>

    suspend fun getFoodTypes(): Flow<Resource<List<FoodType>>>
}