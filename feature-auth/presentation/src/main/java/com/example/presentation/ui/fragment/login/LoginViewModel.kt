package com.example.presentation.ui.fragment.login

import com.example.core_ui.base.BaseViewModel
import com.example.domain.use_case.IsFirstLaunchUseCase

class LoginViewModel(
    private val isFirstLaunchUseCase: IsFirstLaunchUseCase,
): BaseViewModel() {

    fun shouldShowOnBoard(): Boolean = isFirstLaunchUseCase()
}