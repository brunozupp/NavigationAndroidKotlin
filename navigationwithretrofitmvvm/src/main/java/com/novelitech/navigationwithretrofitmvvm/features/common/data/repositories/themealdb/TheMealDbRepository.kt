package com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb

import com.novelitech.navigationwithretrofitmvvm.features.categories.data.models.CategoryModel
import com.novelitech.navigationwithretrofitmvvm.features.common.data.services.themealdb.TheMealDbRestClient
import com.novelitech.navigationwithretrofitmvvm.features.common.data.services.themealdb.TheMealDbService
import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.models.MealDetailsModel
import com.novelitech.navigationwithretrofitmvvm.features.meals.data.models.MealModel

class TheMealDbRepository(
    val service: TheMealDbService
) : ITheMealDbRepository {

    override suspend fun getCategories(): List<CategoryModel> {

        try {

            val response = service.getCategories()

            return response.categories

        } catch (_: Exception) {
            throw Exception("Error while fetching categories")
        }
    }

    override suspend fun getMeals(categoryName: String): List<MealModel> {
        try {

            val response = service.getMeals(categoryName)

            return response.meals

        } catch (_: Exception) {
            throw Exception("Error while fetching categories")
        }
    }

    override suspend fun getMealDetails(mealId: String): MealDetailsModel {
        try {

            val response = service.getMealDetails(mealId)

            return response.meals.first()

        } catch (_: Exception) {
            throw Exception("Error while fetching categories")
        }
    }
}