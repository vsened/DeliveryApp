package com.vsened.deliveryapp.data.mappers

import com.vsened.deliveryapp.data.local.model.FoodTypeEntity
import com.vsened.deliveryapp.data.local.model.MealEntity
import com.vsened.deliveryapp.data.network.model.FoodTypeDto
import com.vsened.deliveryapp.data.network.model.MealDto
import com.vsened.deliveryapp.domain.model.FoodType
import com.vsened.deliveryapp.domain.model.Meal

fun MealDto.toMeal(): Meal {
    return Meal(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}

fun MealEntity.toMeal(): Meal {
    return Meal(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}

fun MealDto.toMealEntity(): MealEntity {
    return MealEntity(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}

fun FoodTypeDto.toFoodType(): FoodType {
    return FoodType(
        name = strCategory
    )
}

fun FoodTypeEntity.toFoodType(): FoodType {
    return FoodType(
        name = strCategory
    )
}

fun FoodTypeDto.toFoodTypeEntity(): FoodTypeEntity {
    return com.vsened.deliveryapp.data.local.model.FoodTypeEntity(
        strCategory = strCategory
    )
}