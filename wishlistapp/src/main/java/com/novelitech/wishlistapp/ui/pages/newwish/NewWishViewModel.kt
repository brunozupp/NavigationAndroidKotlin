package com.novelitech.wishlistapp.ui.pages.newwish

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NewWishViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(NewWishUiState())
    val uiState: StateFlow<NewWishUiState> = _uiState.asStateFlow()

    fun onChangeTitle(value: String) {
        _uiState.update {
            it.copy(title = value)
        }
    }

    fun onChangeDescription(value: String) {
        _uiState.update {
            it.copy(description = value)
        }
    }
}