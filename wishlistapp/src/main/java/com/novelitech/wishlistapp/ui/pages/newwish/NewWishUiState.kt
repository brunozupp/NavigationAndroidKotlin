package com.novelitech.wishlistapp.ui.pages.newwish

data class NewWishUiState(
    val loading: Boolean = false,
    val error: String? = null,
    val title: String = "",
    val description: String = "",
) {

    val hasError: Boolean
        get() = error != null && error.isNotBlank()

    val titleError: String?
        get() = when {
            title.isBlank() -> "Title is required"
            title.length < 3 -> "Title must have more than 3 characters"
            else -> null
        }

    val descriptionError: String?
        get() = when {
            description.isBlank() -> "Description is required"
            description.length < 5 -> "Description must have more than 5 characters"
            else -> null
        }

    val isFormValid: Boolean
        get() = titleError == null && descriptionError == null
}
