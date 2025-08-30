package com.example.domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.example.domain.use_case.IsFirstLaunchUseCase
import com.example.domain.use_case.SetOnBoardingShownUseCase

val domainModule = module {
    factoryOf(::IsFirstLaunchUseCase)
    factoryOf(::SetOnBoardingShownUseCase)
}