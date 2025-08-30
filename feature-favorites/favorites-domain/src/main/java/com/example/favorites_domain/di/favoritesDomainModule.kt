package com.example.favorites_domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.example.favorites_domain.use_case.GetFavoritesUseCase
import com.example.favorites_domain.use_case.OnFavoriteClickUseCase

val favoritesDomainModule = module {
    factoryOf(::GetFavoritesUseCase)
    factoryOf(::OnFavoriteClickUseCase)
}