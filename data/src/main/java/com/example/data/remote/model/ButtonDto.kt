package com.example.data.remote.model

import com.example.core.model.Button
import com.example.data.core.utils.DataMapper

data class ButtonDto(
    val text: String
): DataMapper<Button> {

    override fun toDomain() = Button(
        text = text
    )
}