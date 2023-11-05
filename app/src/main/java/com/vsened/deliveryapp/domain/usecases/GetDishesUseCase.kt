package com.vsened.deliveryapp.domain.usecases

import com.vsened.deliveryapp.domain.repository.Repository
import javax.inject.Inject

class GetDishesUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(query: String) = repository.getDishes(query)
}