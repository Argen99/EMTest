package com.example.main_domain.di

import org.koin.core.module.dsl.factoryOf
import com.example.main_domain.use_case.GetCoursesUseCase
import com.example.main_domain.use_case.OnFavoritesClickUseCase
import org.koin.dsl.module

val mainDomainModule = module {
    factoryOf(::GetCoursesUseCase)
    factoryOf(::OnFavoritesClickUseCase)
}