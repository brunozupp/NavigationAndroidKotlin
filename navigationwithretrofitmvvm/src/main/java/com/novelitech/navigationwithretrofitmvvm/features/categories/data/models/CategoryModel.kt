package com.novelitech.navigationwithretrofitmvvm.features.categories.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryModel(
    @SerialName("idCategory")
    val id: String,

    @SerialName("strCategory")
    val name: String,

    @SerialName("strCategoryThumb")
    val image: String,

    @SerialName("strCategoryDescription")
    val description: String,
)
