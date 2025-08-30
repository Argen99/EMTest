package com.example.presentation.ui.fragment.onboard

import com.example.core_ui.base.BaseViewModel
import com.example.domain.use_case.SetOnBoardingShownUseCase

class OnboardViewModel(
    private val setOnBoardingShownUseCase: SetOnBoardingShownUseCase
): BaseViewModel() {

    fun setOnBoardingShown(): Unit = setOnBoardingShownUseCase()
}