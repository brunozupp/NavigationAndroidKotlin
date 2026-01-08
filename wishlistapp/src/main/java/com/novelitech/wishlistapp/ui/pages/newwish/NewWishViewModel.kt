package com.novelitech.wishlistapp.ui.pages.newwish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novelitech.wishlistapp.core.events.UiEvent
import com.novelitech.wishlistapp.data.entities.WishEntity
import com.novelitech.wishlistapp.data.repositories.IWishesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewWishViewModel(
    private val repository: IWishesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewWishUiState())
    val uiState: StateFlow<NewWishUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun initializeFieldsOnEditing(wish: WishEntity) {
        _uiState.update {
            it.copy(title = wish.title, description = wish.description)
        }
    }

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

    fun saveNewWish() {

        _uiState.update {
            it.copy(loading = true, error = null)
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.insert(
                    WishEntity(
                        title = _uiState.value.title,
                        description = _uiState.value.description,
                    )
                )

                _uiState.update {
                    it.copy(loading = false)
                }

                _uiEvent.emit(UiEvent.Success)

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(loading = false, error = e.message ?: "Something went wrong")
                }
            }
        }
    }

    fun updateWish(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(
                WishEntity(
                    id = id,
                    title = _uiState.value.title,
                    description = _uiState.value.description,
                )
            )
        }
    }
}