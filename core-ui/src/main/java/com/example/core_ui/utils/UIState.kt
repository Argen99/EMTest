package com.example.core_ui.utils

sealed class UIState<T> {
    class Idle<T> : UIState<T>()
    class Loading<T> : UIState<T>()
    class Error<T>(val error: String) : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
}

//class SearchScreen<T> (showAllVacancies: Boolean ,data: T) : UIState.Success<T>(data)
//
//sealed class CustomUIState<T> : UIState<T>() {
//    class ShowAllVacancies<T>(val data: T) : CustomUIState<T>()
//}
