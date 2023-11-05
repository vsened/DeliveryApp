package com.vsened.deliveryapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vsened.deliveryapp.data.local.model.FoodTypeEntity
import com.vsened.deliveryapp.data.local.model.MealEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeals(
        meals: List<MealEntity>
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodTypes(
        foodTypes: List<FoodTypeEntity>
    )

    @Query("SELECT * FROM mealentity")
    fun getMealsList(): Flow<List<MealEntity>>

    @Query("SELECT * FROM FoodTypeEntity")
    fun getFoodTypesList(): Flow<List<FoodTypeEntity>>
}