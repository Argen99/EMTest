package com.example.data.local.room.entity

import com.example.core.model.Address
import com.example.data.core.utils.DataMapper

data class AddressEntity(
    val town: String,
    val street: String,
    val house: String
): DataMapper<Address> {

    override fun toDomain() = Address(
        town = town,
        street = street,
        house = house
    )
}

fun Address.toEntity() = AddressEntity(
    town = town,
    street = street,
    house = house,
)