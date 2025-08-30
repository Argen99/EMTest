package com.example.main_presentation.ui.fragment.course_info

import androidx.lifecycle.viewModelScope
import com.example.core.model.Course
import com.example.core_ui.base.BaseViewModel
import com.example.main_domain.use_case.OnFavoritesClickUseCase
import kotlinx.coroutines.launch

class CourseInfoViewModel(
    private val onFavoriteClickUseCase: OnFavoritesClickUseCase,
) : BaseViewModel() {

    fun onFavoriteClick(course: Course) {
        viewModelScope.launch {
            onFavoriteClickUseCase(course)
        }
    }
}