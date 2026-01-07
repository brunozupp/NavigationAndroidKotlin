package com.novelitech.wishlistapp.ui.pages.wishlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novelitech.wishlistapp.data.repositories.IWishesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class WishlistViewModel(
    private val repository: IWishesRepository,
) : ViewModel() {

//    private val _uiState = MutableStateFlow(WishlistUiState())
//    val uiState: StateFlow<WishlistUiState> = _uiState.asStateFlow()

    /**
     * As I am using Flow to return the value from .getAll() I need to sign the state in this way
     * Flow is Cold, Continuous and Emits every DB change automatically. So, this is perfect for
     * Compose
     *
     * This approach is essential because it is:
     * - No mutable state
     * - No manual syncing
     * - Always consistent
     * - Fully reactive
     *
     * And can be considered the best approach because it has a single source of truth:
     * Room DB -> Flow -> UiState -> UI
     */
    val uiState: StateFlow<WishlistUiState> = repository.getAll()
        .map { wishes ->
            WishlistUiState(
                loading = false,
                wishes = wishes,
            )
        }
        .onStart {
            emit(WishlistUiState(loading = true))
        }
        .catch { throwable ->
            emit(WishlistUiState(
                loading = false,
                error = throwable.message ?: "Something went wrong"
            ))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = WishlistUiState(loading = true)
        )
}