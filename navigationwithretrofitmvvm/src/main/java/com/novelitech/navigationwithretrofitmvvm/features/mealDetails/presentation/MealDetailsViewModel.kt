package com.novelitech.navigationwithretrofitmvvm.features.mealDetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb.ITheMealDbRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealDetailsViewModel(
    private val repository: ITheMealDbRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MealDetailsUiState())
    val uiState: StateFlow<MealDetailsUiState> = _uiState.asStateFlow()

    fun fetchDetails(mealId: String) {

        _uiState.value = _uiState.value.copy(
            loading = true,
            error = "",
        )

        viewModelScope.launch {
            try {
                val response = repository.getMealDetails(mealId)

                _uiState.value = _uiState.value.copy(
                    loading = false,
                    details = response,
                )

            } catch(e: Exception) {
                _uiState.value = _uiState.value.copy(
                    loading = false,
                    error = e.message ?: "Something went wrong",
                )
            }
        }
    }
}