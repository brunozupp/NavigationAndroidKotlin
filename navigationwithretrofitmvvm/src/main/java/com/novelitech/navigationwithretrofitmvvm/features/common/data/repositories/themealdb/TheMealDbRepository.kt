package com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb

import com.novelitech.navigationwithretrofitmvvm.features.categories.data.models.CategoryModel
import com.novelitech.navigationwithretrofitmvvm.features.common.data.services.themealdb.TheMealDbRestClient
import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.models.MealDetailsModel
import com.novelitech.navigationwithretrofitmvvm.features.meals.data.models.MealModel

class TheMealDbRepository(
    val client: TheMealDbRestClient
) : ITheMealDbRepository {

    override suspend fun getCategories(): List<CategoryModel> {

        try {

            val response = client.theMealDbRestClient.getCategories()

            return response.categories

        } catch (_: Exception) {
            throw Exception("Error while fetching categories")
        }
    }

    override suspend fun getMeals(categoryName: String): List<MealModel> {
        try {

            val response = client.theMealDbRestClient.getMeals(categoryName)

            return response.meals

        } catch (_: Exception) {
            throw Exception("Error while fetching categories")
        }
    }

    override suspend fun getMealDetails(mealId: String): MealDetailsModel {
        try {

            val response = client.theMealDbRestClient.getMealDetails(mealId)

            return response.meals.first()

        } catch (_: Exception) {
            throw Exception("Error while fetching categories")
        }
    }
}