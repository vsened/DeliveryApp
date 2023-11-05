package com.vsened.deliveryapp.domain.usecases

import com.vsened.deliveryapp.domain.repository.Repository
import javax.inject.Inject

class GetFoodTypesUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getFoodTypes()
}