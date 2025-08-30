package com.example.core_ui.utils

import android.text.InputFilter

object InputFilters {
    val LatinOnly = InputFilter { source, start, end, _, _, _ ->
        val regex = Regex("^[a-zA-Z0-9@._-]+$")
        val input = source.subSequence(start, end)
        if (regex.matches(input)) null else ""
    }
}