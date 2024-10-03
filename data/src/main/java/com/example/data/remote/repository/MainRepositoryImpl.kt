package com.example.data.remote.repository

import com.example.core.Either
import com.example.core.model.JobResponse
import com.example.core.model.Vacancy
import com.example.data.core.utils.makeNetworkRequest
import com.example.data.core.utils.makeRequest
import com.example.data.local.room.dao.VacancyDao
import com.example.data.local.room.entity.toEntity
import com.example.data.remote.api_service.MainApiService
import com.example.domain.repository.FavoritesRepository
import com.example.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainRepositoryImpl(
    private val apiService: MainApiService,
    private val vacancyDao: VacancyDao
) : SearchRepository, FavoritesRepository {

    override fun getJobOffersAndVacancies(): Flow<Either<String, JobResponse>> =
        makeNetworkRequest {
            val response = apiService.getJobOffersAndVacancies()
            response.vacancies.map { vacancy ->
                vacancy.isFavorite = vacancyDao.isVacancyExists(vacancy.id) > 0
            }
            response.toDomain()
        }

    override suspend fun toFavorites(vacancy: Vacancy) {
        if (vacancy.isFavorite) {
            vacancyDao.insert(vacancy.toEntity())
        } else {
            vacancyDao.delete(vacancy.toEntity())
        }
    }

    override fun getFavoriteVacancies(): Flow<Either<String, List<Vacancy>>> = makeRequest {
        vacancyDao.getAll().map { list -> list.map { it.toDomain() } }
    }
}