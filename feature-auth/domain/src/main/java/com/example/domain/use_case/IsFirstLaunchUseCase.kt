package com.example.domain.use_case

import com.example.domain.repository.UserPreferencesRepository

class IsFirstLaunchUseCase(
    private val repository: UserPreferencesRepository
) {
    operator fun invoke(): Boolean {
        return repository.isFirstLaunch()
    }
}