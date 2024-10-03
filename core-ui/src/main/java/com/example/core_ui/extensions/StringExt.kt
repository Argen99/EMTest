package com.example.core_ui.extensions

import android.os.Build
import com.example.core_ui.R
import com.example.core_ui.utils.DateFormatPatterns
import com.example.core_ui.utils.OfferType
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

fun String.getIconById(): Int? = when (this) {
    OfferType.NEAR_VACANCIES.name.lowercase() -> R.drawable.ic_location
    OfferType.LEVEL_UP_RESUME.name.lowercase() -> R.drawable.ic_star
    OfferType.TEMPORARY_JOB.name.lowercase() -> R.drawable.ic_doc
    else -> null
}

fun String.formatDate(
    inputPattern: String = DateFormatPatterns.DATE_PATTERN_ISO,
    outputPattern: String = DateFormatPatterns.DATE_PATTERN_DAY_MONTH
): String? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val inputFormatter = DateTimeFormatter.ofPattern(inputPattern, Locale("ru"))
        val outputFormatter = DateTimeFormatter.ofPattern(outputPattern, Locale("ru"))
        val date = LocalDate.parse(this, inputFormatter)
        return date.format(outputFormatter)
    } else {
        val inputFormatter = SimpleDateFormat(inputPattern, Locale.getDefault())
        val outputFormatter = SimpleDateFormat(outputPattern, Locale.getDefault())
        val date: Date? = inputFormatter.parse(this)
        date?.let { outputFormatter.format(it) }
    }
}