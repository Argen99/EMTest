package com.example.presentation.ui.fragments.search

import androidx.lifecycle.viewModelScope
import com.example.core.model.JobResponse
import com.example.core.model.Vacancy
import com.example.core_ui.base.BaseViewModel
import com.example.domain.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: SearchRepository
) : BaseViewModel() {

    private val _mainData = mutableUiStateFlow<JobResponse>()
    val mainData = _mainData.asStateFlow()
    private val _showAllVacancies = MutableStateFlow<Boolean?>(null)
    val showAllVacancies = _showAllVacancies.asStateFlow()
    var allVacancies = listOf<Vacancy>()

    init {
        repository.getJobOffersAndVacancies().gatherRequest(_mainData)
    }

    fun toFavorite(vacancy: Vacancy) {
        viewModelScope.launch {
            repository.toFavorites(vacancy)
        }
    }

    fun switchScreenState() {
        _showAllVacancies.update {
            if (it == null)
                true
            else !it
        }
    }
}