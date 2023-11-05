package com.vsened.deliveryapp.presentation.adapters.foodtypes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.vsened.deliveryapp.databinding.FoodTypeItemBinding
import com.vsened.deliveryapp.domain.model.FoodType

class FoodTypeAdapter(
    private val context: Context
): ListAdapter<FoodType, FoodTypeViewHolder>(FoodTypeDiffCallback) {

    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodTypeViewHolder {
        val binding = FoodTypeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FoodTypeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodTypeViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            tvName.text = item.name
            if (onItemClickListener != null) {
                root.setOnClickListener {
                    onItemClickListener?.onItemClick(position)
                }
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(itemIndex: Int)
    }
}