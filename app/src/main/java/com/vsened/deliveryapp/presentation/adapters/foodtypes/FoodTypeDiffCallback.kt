package com.vsened.deliveryapp.presentation.adapters.foodtypes

import androidx.recyclerview.widget.DiffUtil
import com.vsened.deliveryapp.domain.model.Add
import com.vsened.deliveryapp.domain.model.FoodType

object FoodTypeDiffCallback: DiffUtil.ItemCallback<FoodType>() {
    override fun areItemsTheSame(oldItem: FoodType, newItem: FoodType): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: FoodType, newItem: FoodType): Boolean {
        return oldItem == newItem
    }
}