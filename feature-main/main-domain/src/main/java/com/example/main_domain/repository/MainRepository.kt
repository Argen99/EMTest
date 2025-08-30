package com.example.main_domain.repository

import com.example.core.Either
import com.example.core.model.Course
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getCourses(): Flow<Either<String, List<Course>>>
    suspend fun onFavoriteClick(course: Course)
}