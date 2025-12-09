package com.novelitech.navigationwithretrofitmvvm.features.meals.presentation

import com.novelitech.navigationwithretrofitmvvm.features.meals.data.models.MealModel

data class MealsUiState(
    val loading: Boolean = false,
    val error: String? = null,
    val meals: List<MealModel> = emptyList()
)
