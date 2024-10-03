package com.example.presentation.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import com.example.core.DisplayableItem
import com.example.core.model.Vacancy
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainAdapter(
    context: Context,
    onOfferItemClick: ((link: String) -> Unit)? = null,
    onFavoriteClick: ((vacancy: Vacancy) -> Unit)? = null,
    onVacancyItemClick: (() -> Unit)? = null,
) : ListDelegationAdapter<List<DisplayableItem>>(
    offerAdapterDelegate(onOfferItemClick),
    vacancyAdapterDelegate(context, onFavoriteClick, onVacancyItemClick)
) {
    @SuppressLint("NotifyDataSetChanged")
    override fun setItems(items: List<DisplayableItem>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}