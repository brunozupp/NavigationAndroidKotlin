package com.novelitech.navigationwithretrofitmvvm.features.meals.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb.ITheMealDbRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealsViewModel(
    private val repository: ITheMealDbRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MealsUiState())
    val uiState: StateFlow<MealsUiState> = _uiState.asStateFlow()

    fun fetchMeals(categoryName: String) {

        _uiState.value = _uiState.value.copy(
            loading = true,
            error = null,
        )

        viewModelScope.launch {
            try {

                val response = repository.getMeals(
                    categoryName = categoryName,
                )

                _uiState.value = _uiState.value.copy(
                    loading = false,
                    meals = response,
                )

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    loading = false,
                    error = e.message ?: "Something went wrong",
                )
            }
        }


    }
}