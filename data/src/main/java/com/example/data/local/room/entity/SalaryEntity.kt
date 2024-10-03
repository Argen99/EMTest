package com.example.data.local.room.entity

import com.example.core.model.Salary
import com.example.data.core.utils.DataMapper

data class SalaryEntity(
    val short: String?,
    val full: String
): DataMapper<Salary> {

    override fun toDomain() = Salary(
        short = short,
        full = full
    )
}

fun Salary.toEntity() = SalaryEntity(
    short = short,
    full = full,
)