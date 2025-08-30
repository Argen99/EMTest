package com.example.core_ui.extesions

import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavController.safeNavigation(
    directions: NavDirections
) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}