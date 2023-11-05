package com.vsened.deliveryapp.presentation.adapters.meals

import androidx.recyclerview.widget.DiffUtil
import com.vsened.deliveryapp.domain.model.Meal

object MealDiffCallback: DiffUtil.ItemCallback<Meal>() {
    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }
}