package com.novelitech.navigationwithretrofitmvvm.features.meals.data.models

import kotlinx.serialization.Serializable

@Serializable
data class MealsModel(
    val meals: List<MealModel>
)
