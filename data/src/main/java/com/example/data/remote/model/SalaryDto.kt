package com.example.data.remote.model

import com.example.core.model.Salary
import com.example.data.core.utils.DataMapper

data class SalaryDto(
    val short: String?,
    val full: String
): DataMapper<Salary> {

    override fun toDomain() = Salary(
        short = short,
        full = full
    )
}