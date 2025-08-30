package com.example.domain.repository

interface UserPreferencesRepository {
    fun isFirstLaunch(): Boolean
    fun setOnBoardingShown()
}