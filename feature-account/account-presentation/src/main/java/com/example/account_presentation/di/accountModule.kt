package com.example.account_presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.account_presentation.ui.fragment.AccountViewModel

val accountModule = module {
    viewModelOf(::AccountViewModel)
}