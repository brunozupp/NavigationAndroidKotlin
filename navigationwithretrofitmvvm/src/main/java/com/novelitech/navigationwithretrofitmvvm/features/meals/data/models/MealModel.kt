package com.novelitech.navigationwithretrofitmvvm.features.meals.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealModel(
    @SerialName("idMeal")
    val id: String,

    @SerialName("strMeal")
    val name: String,

    @SerialName("strMealThumb")
    val image: String,
)
