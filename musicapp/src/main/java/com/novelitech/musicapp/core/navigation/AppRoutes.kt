package com.novelitech.musicapp.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoutes {

    @Serializable
    data object Home : AppRoutes

    @Serializable
    data object EloCard: AppRoutes

    @Serializable
    data object Helpdesk: AppRoutes

    @Serializable
    data object Notes: AppRoutes
}