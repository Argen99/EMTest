package com.example.domain.repository

import com.example.core.Either
import com.example.core.model.JobResponse
import com.example.core.model.Vacancy
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getJobOffersAndVacancies(): Flow<Either<String, JobResponse>>
    suspend fun toFavorites(vacancy: Vacancy)
}