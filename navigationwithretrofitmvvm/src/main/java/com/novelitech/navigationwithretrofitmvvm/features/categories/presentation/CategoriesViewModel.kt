package com.novelitech.navigationwithretrofitmvvm.features.categories.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb.ITheMealDbRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val repository: ITheMealDbRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesUiState())
    val uiState: StateFlow<CategoriesUiState> = _uiState.asStateFlow()

    init {
        fetchCategories()
    }

    private fun fetchCategories() {

        _uiState.value = _uiState.value.copy(
            loading = true,
            error = null,
        )

        viewModelScope.launch {
            try {

                val response = repository.getCategories()

                _uiState.value = _uiState.value.copy(
                    loading = false,
                    categories = response
                )

            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    loading = false,
                    error = e.message ?: "Something went wrong"
                )
            }
        }
    }
}