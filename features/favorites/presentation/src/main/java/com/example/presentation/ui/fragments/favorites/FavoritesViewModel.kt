package com.example.presentation.ui.fragments.favorites

import androidx.lifecycle.viewModelScope
import com.example.core.model.Vacancy
import com.example.core_ui.base.BaseViewModel
import com.example.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val repository: FavoritesRepository
): BaseViewModel() {

    private val _favoritesState = mutableUiStateFlow<List<Vacancy>>()
    val favoritesState = _favoritesState.asStateFlow()

    init {
        repository.getFavoriteVacancies().gatherRequest(_favoritesState)
    }

    fun toFavorite(vacancy: Vacancy) {
        viewModelScope.launch {
            repository.toFavorites(vacancy)
        }
    }
}