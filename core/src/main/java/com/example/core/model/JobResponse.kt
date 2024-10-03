package com.example.core.model

data class JobResponse(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>,
)