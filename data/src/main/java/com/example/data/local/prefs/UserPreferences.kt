package com.example.data.local.prefs

import android.content.Context

class UserPreferences(context: Context) {

    private val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    var isFirstLaunch: Boolean
        get() = prefs.getBoolean(KEY_FIRST_LAUNCH, true)
        set(value) = prefs.edit().putBoolean(KEY_FIRST_LAUNCH, value).apply()

    companion object {
        private const val KEY_FIRST_LAUNCH = "key_first_launch"
    }
}