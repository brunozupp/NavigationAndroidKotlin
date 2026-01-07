package com.novelitech.wishlistapp.core.events

sealed interface UiEvent {

    data object Success : UiEvent
}