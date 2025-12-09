package com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.models

import kotlinx.serialization.Serializable

/// TODO: Do a special serializer to avoid get a list
@Serializable
data class MealDetailsWrapperModel(
    val meals: List<MealDetailsModel>
)
