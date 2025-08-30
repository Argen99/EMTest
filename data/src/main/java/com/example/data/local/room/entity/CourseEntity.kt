package com.example.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.model.Course
import com.example.data.utils.DataMapper

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    var hasLike: Boolean,
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

fun Course.toEntity() = CourseEntity(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    startDate = startDate,
    hasLike = hasLike,
    publishDate = publishDate,
)