package com.novelitech.navigationwithretrofitmvvm.features.providers

import com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb.ITheMealDbRepository
import com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb.TheMealDbRepository
import com.novelitech.navigationwithretrofitmvvm.features.common.data.services.themealdb.TheMealDbRestClient

object ProviderRepository {

    fun provideTheMealDbRepository() : ITheMealDbRepository {
        return TheMealDbRepository(
            service = TheMealDbRestClient.theMealDbRestClient,
        )
    }
}