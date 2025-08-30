package com.example.data.local.prefs

import com.example.domain.repository.UserPreferencesRepository

class UserPreferencesRepositoryImpl(
    private val userPreferences: UserPreferences
) : UserPreferencesRepository {

    override fun isFirstLaunch(): Boolean {
        return userPreferences.isFirstLaunch
    }

    override fun setOnBoardingShown() {
        userPreferences.isFirstLaunch = false
    }
}