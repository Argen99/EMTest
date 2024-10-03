package com.example.data.remote.api_service

import com.example.data.remote.model.JobResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApiService {

    @GET("u/0/uc")
    suspend fun getJobOffersAndVacancies(
        @Query("id") id: String = ID,
        @Query("export") exportType: String = EXP_TYPE
    ): JobResponseDto

    companion object {
        const val ID = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r"
        const val EXP_TYPE = "download"
    }
}