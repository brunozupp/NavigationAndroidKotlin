package com.novelitech.navigationwithretrofitmvvm.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoutes {

    @Serializable
    data object Categories : AppRoutes

    @Serializable
    data class Meals(val categoryName: String) : AppRoutes

    @Serializable
    data class MealDetails(val mealId: String) : AppRoutes
}