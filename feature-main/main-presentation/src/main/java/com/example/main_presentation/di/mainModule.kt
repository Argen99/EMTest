package com.example.main_presentation.di

import com.example.main_domain.di.mainDomainModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import com.example.main_presentation.ui.fragment.MainViewModel
import com.example.main_presentation.ui.fragment.course_info.CourseInfoViewModel
import org.koin.dsl.module

val mainModule = module {
    includes(mainDomainModule)
    viewModelOf(::MainViewModel)
    viewModelOf(::CourseInfoViewModel)
}