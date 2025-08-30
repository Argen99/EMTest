package com.example.presentation.di

import com.example.domain.di.domainModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.presentation.ui.fragment.login.LoginViewModel
import com.example.presentation.ui.fragment.onboard.OnboardViewModel

val authModule = module {
    includes(domainModule)
    viewModelOf(::LoginViewModel)
    viewModelOf(::OnboardViewModel)
}