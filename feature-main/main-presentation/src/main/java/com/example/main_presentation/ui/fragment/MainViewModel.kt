package com.example.main_presentation.ui.fragment

import androidx.lifecycle.viewModelScope
import com.example.core.model.Course
import com.example.core_ui.base.BaseViewModel
import com.example.core_ui.utils.DateFormatPatterns
import com.example.core_ui.utils.UIState
import com.example.main_domain.use_case.GetCoursesUseCase
import com.example.main_domain.use_case.OnFavoritesClickUseCase
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class MainViewModel(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val addCourseToFavorites: OnFavoritesClickUseCase,
) : BaseViewModel() {

    private val _coursesState = mutableUiStateFlow<List<Course>>()
    val coursesState = _coursesState.asStateFlow()


    fun getCourses() {
        getCoursesUseCase().gatherRequest(_coursesState)
    }

    fun sortCoursesByPublishDate() {
        val currentState = _coursesState.value
        if (currentState is UIState.Success) {
            val formatter = SimpleDateFormat(DateFormatPatterns.SERVER_DATE_FORMAT, Locale.getDefault())
            val sortedList = currentState.data.sortedByDescending {
                formatter.parse(it.publishDate)
            }
            _coursesState.value = UIState.Success(sortedList)
        }
    }

    fun onFavoriteClick(item: Course) {
        viewModelScope.launch {
            addCourseToFavorites(item)
        }
    }
}