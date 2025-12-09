package com.novelitech.navigationwithretrofitmvvm.features.common.data.services.themealdb

import com.novelitech.navigationwithretrofitmvvm.features.categories.data.models.CategoriesModel
import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.data.models.MealDetailsWrapperModel
import com.novelitech.navigationwithretrofitmvvm.features.meals.data.models.MealsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMealDbService {

    @GET("categories.php")
    suspend fun getCategories() : CategoriesModel

    @GET("filter.php")
    suspend fun getMeals(@Query("c") categoryName: String) : MealsModel

    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i") mealId: String) : MealDetailsWrapperModel
}