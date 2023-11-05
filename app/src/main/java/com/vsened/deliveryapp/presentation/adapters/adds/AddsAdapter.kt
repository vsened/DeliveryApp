package com.vsened.deliveryapp.presentation.adapters.adds

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.vsened.deliveryapp.databinding.AddsItemBinding
import com.vsened.deliveryapp.domain.model.Add

class AddsAdapter(
    private val context: Context
): ListAdapter<Add, AddsViewHolder>(AddDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddsViewHolder {
        val binding = AddsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AddsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddsViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            imageViewPoster.setImageDrawable(context.getDrawable(item.id))
        }
    }
}