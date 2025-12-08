package com.novelitech.navigationandroidkotlin.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoutes {

    @Serializable
    data object First : AppRoutes

    @Serializable
    data class Second(val name: String) : AppRoutes
}

