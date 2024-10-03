package com.example.core_ui.extensions

import androidx.annotation.IdRes
import androidx.navigation.NavController

fun NavController.safeNavigation(
    @IdRes actionId: Int,
) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}