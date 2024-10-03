package com.example.data.local.room.entity

import com.example.core.model.Experience
import com.example.data.core.utils.DataMapper

data class ExperienceEntity(
    val previewText: String,
    val text: String
): DataMapper<Experience> {

    override fun toDomain() = Experience(
        previewText = previewText,
        text = text
    )
}

fun Experience.toEntity() = ExperienceEntity(
    previewText = previewText,
    text = text,
)