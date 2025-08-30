package com.example.favorites_domain.use_case

import com.example.favorites_domain.repository.FavoritesRepository

class GetFavoritesUseCase(
    private val favoritesRepository: FavoritesRepository
) {
    operator fun invoke() = favoritesRepository.getFavorites()
}