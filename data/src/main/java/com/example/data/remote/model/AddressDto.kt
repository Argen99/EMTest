package com.example.data.remote.model

import com.example.core.model.Address
import com.example.data.core.utils.DataMapper

data class AddressDto(
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