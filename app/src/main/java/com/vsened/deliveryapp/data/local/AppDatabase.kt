package com.vsened.deliveryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vsened.deliveryapp.data.local.model.FoodTypeEntity
import com.vsened.deliveryapp.data.local.model.MealEntity

@Database(
    entities = [MealEntity::class, FoodTypeEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val dao: AppDao
}