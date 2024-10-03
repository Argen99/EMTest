package com.example.data.remote.model

import com.example.core.model.Offer
import com.example.data.core.utils.DataMapper

data class OfferDto(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonDto?
): DataMapper<Offer> {

    override fun toDomain() = Offer(
        id = id,
        title = title,
        link = link,
        button = button?.toDomain(),
    )
}