package com.example.presentation.di

import com.example.domain.di.domainModule
import com.example.presentation.ui.fragments.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val searchModule = module {
    includes(domainModule)
    viewModelOf(::SearchViewModel)
}