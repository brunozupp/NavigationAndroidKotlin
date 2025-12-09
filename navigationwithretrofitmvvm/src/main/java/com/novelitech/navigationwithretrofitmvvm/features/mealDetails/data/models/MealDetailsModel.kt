package com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.models

import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.serializers.MealDetailsSerializer
import kotlinx.serialization.Serializable

@Serializable(with = MealDetailsSerializer::class)
data class MealDetailsModel(
    val id: String,
    val name: String,
    val category: String,
    val area: String,
    val instructions: String,
    val ingredients: List<String>,
    val measures: List<String>
)