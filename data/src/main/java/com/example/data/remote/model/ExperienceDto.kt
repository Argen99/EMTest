package com.example.data.remote.model

import com.example.core.model.Experience
import com.example.data.core.utils.DataMapper

data class ExperienceDto(
    val previewText: String,
    val text: String
): DataMapper<Experience> {

    override fun toDomain() = Experience(
        previewText = previewText,
        text = text
    )
}