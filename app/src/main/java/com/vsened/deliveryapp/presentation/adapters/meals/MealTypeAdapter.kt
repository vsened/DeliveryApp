package com.vsened.deliveryapp.presentation.adapters.meals

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import com.vsened.deliveryapp.databinding.FoodTypeItemBinding
import com.vsened.deliveryapp.databinding.MenuItemBinding
import com.vsened.deliveryapp.domain.model.FoodType
import com.vsened.deliveryapp.domain.model.Meal
import kotlin.random.Random

class MealTypeAdapter(
    private val context: Context
): ListAdapter<Meal, MealViewHolder>(MealDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = MenuItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            itemName.text = item.strMeal
            itemDescription.text = LoremIpsum(7).toString()
            itemPrice.text = "от ${(Random.nextInt(400 - 200) + 200)} руб."
            Picasso.get().load(item.strMealThumb).into(itemPicture)
        }
    }
}