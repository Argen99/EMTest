package com.example.domain.use_case

import com.example.domain.repository.UserPreferencesRepository

class SetOnBoardingShownUseCase(
    private val repository: UserPreferencesRepository
) {
    operator fun invoke() {
        repository.setOnBoardingShown()
    }
}