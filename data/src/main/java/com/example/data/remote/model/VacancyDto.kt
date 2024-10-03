package com.example.data.remote.model

import com.example.core.model.Vacancy
import com.example.data.core.utils.DataMapper

data class VacancyDto(
    val id: String,
    val lookingNumber: Int?,
    val title: String,
    val address: AddressDto,
    val company: String,
    val experience: ExperienceDto,
    val publishedDate: String,
    var isFavorite: Boolean,
    val salary: SalaryDto,
    val schedules: List<String>,
    val appliedNumber: Int?,
    val description: String?,
    val responsibilities: String,
    val questions: List<String>
): DataMapper<Vacancy> {

    override fun toDomain() = Vacancy(
        id = id,
        lookingNumber = lookingNumber,
        title = title,
        address = address.toDomain(),
        company = company,
        experience = experience.toDomain(),
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = salary.toDomain(),
        schedules = schedules,
        appliedNumber = appliedNumber,
        description = description,
        responsibilities = responsibilities,
        questions = questions,
    )
}