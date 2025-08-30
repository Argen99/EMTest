package com.example.data.remote.dto

import com.example.core.model.Course
import com.example.data.utils.DataMapper
import com.google.gson.annotations.SerializedName

data class CourseDto(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String,
): DataMapper<Course> {

    override fun toDomain() = Course(
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = hasLike,
        publishDate = publishDate,
    )
}