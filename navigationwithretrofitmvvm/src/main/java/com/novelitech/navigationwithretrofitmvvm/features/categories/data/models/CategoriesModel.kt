package com.novelitech.navigationwithretrofitmvvm.features.categories.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CategoriesModel(
    val categories: List<CategoryModel>
)
