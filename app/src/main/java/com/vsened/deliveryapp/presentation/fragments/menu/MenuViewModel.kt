package com.vsened.deliveryapp.presentation.fragments.menu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsened.deliveryapp.domain.usecases.GetDishesUseCase
import com.vsened.deliveryapp.domain.usecases.GetFoodTypesUseCase
import com.vsened.deliveryapp.presentation.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getDishesUseCase: GetDishesUseCase,
    private val getFoodTypesUseCase: GetFoodTypesUseCase,
): ViewModel() {
    var state by mutableStateOf(MenuState())

    init {
        getFoodTypes()
        getDishes("Beef")
    }


    private fun getDishes(query: String) {
        viewModelScope.launch {
            getDishesUseCase(query)
                .collect {result ->
                    when (result) {
                        is Resource.Error -> {
                            Log.d("GetDishesUseCase", "Something wrong: ${result.message}")
                        }
                        is Resource.Loading -> {
                            state = state.copy(
                                isLoading = result.isLoading
                            )
                        }
                        is Resource.Success -> {
                            result.data?.let {
                                state = state.copy(
                                    meals = it
                                )
                            }
                        }
                    }
                }
        }
    }

    private fun getFoodTypes(){
        viewModelScope.launch {
            getFoodTypesUseCase()
                .collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            Log.d("GetDishesUseCase", "Something wrong: ${result.message}")
                        }
                        is Resource.Loading -> {
                            state = state.copy(
                                isLoading = result.isLoading
                            )
                        }
                        is Resource.Success -> {
                            result.data?.let {
                                state = state.copy(
                                    types = it
                                )
                            }
                        }
                    }
                }
        }
    }
}
