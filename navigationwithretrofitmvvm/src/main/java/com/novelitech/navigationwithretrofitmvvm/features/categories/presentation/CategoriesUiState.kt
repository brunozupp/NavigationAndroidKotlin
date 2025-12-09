package com.novelitech.navigationwithretrofitmvvm.features.categories.presentation

import com.novelitech.navigationwithretrofitmvvm.features.categories.data.models.CategoryModel

data class CategoriesUiState(
    val loading: Boolean = false,
    val error: String? = null,
    val categories: List<CategoryModel> = emptyList()
)
