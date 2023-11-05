package com.vsened.deliveryapp.data.network

import com.vsened.deliveryapp.data.network.model.DishDto
import com.vsened.deliveryapp.data.network.model.FoodTypeDto
import com.vsened.deliveryapp.data.network.model.FoodTypesDto
import com.vsened.deliveryapp.data.network.model.MealDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/json/v1/1/list.php?c=list")
    suspend fun getFoodTypes(): FoodTypesDto

    @GET("api/json/v1/1/filter.php")
    suspend fun getDishes(
        @Query(QUERY_PARAM_MEAL) meal: String
    ): DishDto

    companion object {
        const val BASE_URL = "https://www.themealdb.com/"
        private const val QUERY_PARAM_MEAL = "c"
    }
}