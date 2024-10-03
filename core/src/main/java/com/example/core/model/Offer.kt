package com.example.core.model

import com.example.core.DisplayableItem

data class Offer(
    val id: String?,
    val title: String,
    val link: String,
    val button: Button?
): DisplayableItem