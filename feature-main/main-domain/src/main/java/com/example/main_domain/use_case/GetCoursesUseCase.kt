package com.example.main_domain.use_case

import com.example.main_domain.repository.MainRepository

class GetCoursesUseCase(
    private val repository: MainRepository
) {
    operator fun invoke() = repository.getCourses()
}