package com.vsened.deliveryapp.data.repository

import com.vsened.deliveryapp.data.local.AppDatabase
import com.vsened.deliveryapp.data.mappers.toFoodType
import com.vsened.deliveryapp.data.mappers.toFoodTypeEntity
import com.vsened.deliveryapp.data.mappers.toMeal
import com.vsened.deliveryapp.data.mappers.toMealEntity
import com.vsened.deliveryapp.data.network.ApiService
import com.vsened.deliveryapp.domain.model.FoodType
import com.vsened.deliveryapp.domain.model.Meal
import com.vsened.deliveryapp.domain.repository.Repository
import com.vsened.deliveryapp.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val db: AppDatabase,
) : Repository {

    private val dao = db.dao


    override suspend fun getDishes(query: String): Flow<Resource<List<Meal>>> {
        return flow {
            emit(Resource.Loading(true))
            var remoteDishes = try {
                api.getDishes(query)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            remoteDishes?.let { dishes ->
                dao.insertMeals(dishes.meals.map { it.toMealEntity() })
                emit(Resource.Success(
                    data = dishes.meals.map { it.toMeal() }
                )
                )
            }
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getFoodTypes(): Flow<Resource<List<FoodType>>> {
        return flow {
            emit(Resource.Loading(true))
            var remoteFoodType = try {
                api.getFoodTypes()
            } catch (e: IOException) {
                e.printStackTrace()
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                null
            }
            remoteFoodType?.let { types ->
                dao.insertFoodTypes(types.meals.map { it.toFoodTypeEntity() })
                emit(Resource.Success(
                    data = types.meals.map { it.toFoodType() }
                ))
            }
            emit(Resource.Loading(false))
        }
    }
}