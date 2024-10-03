package com.example.domain.repository

import com.example.core.Either
import com.example.core.model.Vacancy
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    fun getFavoriteVacancies(): Flow<Either<String ,List<Vacancy>>>
    suspend fun toFavorites(vacancy: Vacancy)
}