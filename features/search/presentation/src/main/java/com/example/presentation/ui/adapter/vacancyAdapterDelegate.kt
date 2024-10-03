package com.example.presentation.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.view.isVisible
import com.example.core.DisplayableItem
import com.example.core.model.Vacancy
import com.example.core_ui.databinding.ItemVacancyBinding
import com.example.core_ui.extensions.formatDate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("SetTextI18n")
fun vacancyAdapterDelegate(
    context: Context,
    onFavoriteClick: ((vacancy: Vacancy) -> Unit)?,
    onItemClick: (() -> Unit)?,
) =
    adapterDelegateViewBinding<Vacancy, DisplayableItem, ItemVacancyBinding>(
        { layoutInflater, root -> ItemVacancyBinding.inflate(layoutInflater, root, false) }
    ) {

        bind {
            item.lookingNumber?.let { lookingNumber ->
                val text =
                    "Сейчас ${if (lookingNumber > 1) "просматривают" else "просматривает"} $lookingNumber ${
                        context.resources.getQuantityString(
                            com.example.core_ui.R.plurals.human,
                            lookingNumber
                        )
                    }"
                binding.tvLookingNumber.isVisible = true
                binding.tvLookingNumber.text = text
            }
            binding.tvTitle.text = item.title
            item.salary.short?.let { salary ->
                binding.tvSalary.isVisible = true
                binding.tvSalary.text = salary
            }
            binding.tvAddress.text = item.address.town
            binding.tvCompany.text = item.company
            binding.tvExperience.text = item.experience.previewText
            binding.tvPublishedDate.text = "Опубликовано ${item.publishedDate.formatDate()}"
            binding.btnFavorite.setImageResource(
                if (item.isFavorite) com.example.core_ui.R.drawable.ic_heart_active
                else com.example.core_ui.R.drawable.ic_heart
            )
        }
        binding.btnFavorite.setOnClickListener {
            item.isFavorite = !item.isFavorite
            binding.btnFavorite.setImageResource(
                if (item.isFavorite) com.example.core_ui.R.drawable.ic_heart_active
                else com.example.core_ui.R.drawable.ic_heart
            )
            onFavoriteClick?.invoke(item)
        }

        binding.root.setOnClickListener {
            onItemClick?.invoke()
        }
    }