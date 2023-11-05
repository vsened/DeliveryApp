package com.vsened.deliveryapp.presentation.adapters.adds

import androidx.recyclerview.widget.DiffUtil
import com.vsened.deliveryapp.domain.model.Add

object AddDiffCallback: DiffUtil.ItemCallback<Add>() {
    override fun areItemsTheSame(oldItem: Add, newItem: Add): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Add, newItem: Add): Boolean {
        return oldItem == newItem
    }
}