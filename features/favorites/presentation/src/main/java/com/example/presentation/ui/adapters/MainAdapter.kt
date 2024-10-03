package com.example.presentation.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import com.example.core.DisplayableItem
import com.example.core.model.Vacancy
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainAdapter(
    context: Context,
    onFavoriteClick: ((vacancy: Vacancy) -> Unit)? = null
) : ListDelegationAdapter<List<DisplayableItem>>(
    vacancyAdapterDelegate(
        context = context,
        onFavoriteClick = onFavoriteClick
    )
) {
    @SuppressLint("NotifyDataSetChanged")
    override fun setItems(items: List<DisplayableItem>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}