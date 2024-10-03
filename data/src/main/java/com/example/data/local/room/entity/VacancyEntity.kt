package com.example.data.local.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.model.Vacancy
import com.example.data.core.utils.DataMapper

@Entity(tableName = "vacancies")
data class VacancyEntity(
    @PrimaryKey
    val id: String,
    val lookingNumber: Int?,
    val title: String,
    @Embedded
    val address: AddressEntity,
    val company: String,
    @Embedded
    val experience: ExperienceEntity,
    val publishedDate: String,
    val isFavorite: Boolean,
    @Embedded
    val salary: SalaryEntity,
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

fun Vacancy.toEntity() = VacancyEntity(
    id = id,
    lookingNumber = lookingNumber,
    title = title,
    address = address.toEntity(),
    company = company,
    experience = experience.toEntity(),
    publishedDate = publishedDate,
    isFavorite = isFavorite,
    salary = salary.toEntity(),
    schedules = schedules,
    appliedNumber = appliedNumber,
    description = description,
    responsibilities = responsibilities,
    questions = questions,
)