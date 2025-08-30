package com.example.data.remote.api_service

import com.example.data.remote.dto.CoursesResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApiService {

    @GET(COURSES_URL)
    suspend fun getCourses(): CoursesResponseDto

    companion object {
        const val COURSES_URL = "https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download"
    }
}