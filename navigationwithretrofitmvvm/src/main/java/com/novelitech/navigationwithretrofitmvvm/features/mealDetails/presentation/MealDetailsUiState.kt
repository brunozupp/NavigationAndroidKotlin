package com.novelitech.navigationwithretrofitmvvm.features.mealDetails.presentation

import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.models.MealDetailsModel

data class MealDetailsUiState(
    val loading: Boolean = false,
    val error: String? = null,
    val details: MealDetailsModel? = null
)
