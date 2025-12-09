package com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb

import com.novelitech.navigationwithretrofitmvvm.features.categories.data.models.CategoryModel
import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.models.MealDetailsModel
import com.novelitech.navigationwithretrofitmvvm.features.meals.data.models.MealModel

interface ITheMealDbRepository {

    suspend fun getCategories() : List<CategoryModel>

    suspend fun getMeals(categoryName: String) : List<MealModel>

    suspend fun getMealDetails(mealId: String) : MealDetailsModel
}