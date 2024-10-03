package com.example.presentation.di

import com.example.domain.di.favoritesDomainModule
import com.example.presentation.ui.fragments.favorites.FavoritesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val favoritesModule = module {
    includes(favoritesDomainModule)
    viewModelOf(::FavoritesViewModel)
}