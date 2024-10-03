package com.example.data.remote.model

import com.example.core.model.JobResponse
import com.example.data.core.utils.DataMapper

data class JobResponseDto(
    val offers: List<OfferDto>,
    val vacancies: List<VacancyDto>
): DataMapper<JobResponse> {

    override fun toDomain() = JobResponse(
        offers = offers.map { it.toDomain() },
        vacancies = vacancies.map { it.toDomain() }
    )
}