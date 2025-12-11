package com.novelitech.navigationwithretrofitmvvm.features.providers

import com.novelitech.navigationwithretrofitmvvm.features.categories.presentation.CategoriesViewModel

object ProviderViewModel {

    fun provideCategoriesViewModel() : CategoriesViewModel {
        return CategoriesViewModel(
            repository = ProviderRepository.provideTheMealDbRepository()
        )
    }
}