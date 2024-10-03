package com.example.presentation.ui.adapter

import androidx.core.view.isVisible
import com.example.core.DisplayableItem
import com.example.core.model.Offer
import com.example.core_ui.extensions.getIconById
import com.example.presentation.databinding.ItemOfferBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun offerAdapterDelegate(
    onItemClick: ((link: String) -> Unit)?
) = adapterDelegateViewBinding<Offer, DisplayableItem, ItemOfferBinding>(
    { layoutInflater, root -> ItemOfferBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        val offerIcon = item.id?.getIconById()
        offerIcon?.let { icon ->
            binding.ivIcon.setImageResource(icon)
        }
        binding.tvTitle.text = item.title.trim()
        item.button?.let { button ->
            binding.tvButton.isVisible = true
            binding.tvButton.text = button.text
        } ?: run {
            binding.tvTitle.maxLines = 3
        }
    }

    binding.root.setOnClickListener {
        onItemClick?.invoke(item.link)
    }
}