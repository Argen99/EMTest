package com.example.data.remote.repository

import com.example.core.Either
import com.example.core.model.Course
import com.example.data.local.room.dao.CourseDao
import com.example.data.local.room.entity.toEntity
import com.example.data.remote.api_service.MainApiService
import com.example.data.utils.makeNetworkRequest
import com.example.data.utils.makeRequest
import com.example.favorites_domain.repository.FavoritesRepository
import com.example.main_domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainRepositoryImpl(
    private val apiService: MainApiService,
    private val courseDao: CourseDao,
) : MainRepository, FavoritesRepository {

    override fun getCourses(): Flow<Either<String, List<Course>>> = makeNetworkRequest {
        apiService.getCourses().courses.map {
            it.toDomain().copy(hasLike = courseDao.isCourseExists(it.id) > 0)
        }
    }

    override fun getFavorites(): Flow<Either<String, List<Course>>> = makeRequest {
        courseDao.getCourses().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun onFavoriteClick(course: Course) {
        if (course.hasLike) {
            courseDao.insert(course.toEntity())
        } else {
            courseDao.delete(course.toEntity())
        }
    }
}