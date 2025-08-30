package com.example.favorites_presentation.di

import com.example.favorites_domain.di.favoritesDomainModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import com.example.favorites_presentation.ui.fragment.FavoritesViewModel
import org.koin.dsl.module

val favoritesModule = module {
    includes(favoritesDomainModule)
    viewModelOf(::FavoritesViewModel)
}