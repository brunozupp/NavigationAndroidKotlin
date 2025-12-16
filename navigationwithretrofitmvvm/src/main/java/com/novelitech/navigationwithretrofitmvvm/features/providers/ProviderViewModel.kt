package com.novelitech.navigationwithretrofitmvvm.features.providers

import androidx.lifecycle.ViewModelProvider
import com.novelitech.navigationwithretrofitmvvm.features.categories.presentation.CategoriesViewModel
import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.presentation.MealDetailsViewModel
import com.novelitech.navigationwithretrofitmvvm.features.meals.presentation.MealsViewModel
import com.novelitech.navigationwithretrofitmvvm.features.providers.factories.CategoriesViewModelFactory
import com.novelitech.navigationwithretrofitmvvm.features.providers.factories.MealDetailsViewModelFactory
import com.novelitech.navigationwithretrofitmvvm.features.providers.factories.MealsViewModelFactory

object ProviderViewModel {

    /**
     * When dealing with ViewModel and navigation I need to use Android's ViewModel System and
     * wrap my viewmodel creation to a Factory, if this demands parameters in its constructor.
     * If not, a simple solution is enough (see MyApp.kt)
     *
     * With this approach:
     * - ViewModels survive recomposition
     * - ViewModels survive navigation away/back
     * - State stays intact
     * - No random recreation
     */
    fun provideCategoriesViewModelFactory() : ViewModelProvider.Factory {
        return CategoriesViewModelFactory(
            repository = ProviderRepository.provideTheMealDbRepository()
        )
    }

    fun provideMealsViewModelFactory() : ViewModelProvider.Factory {
        return MealsViewModelFactory(
            repository = ProviderRepository.provideTheMealDbRepository()
        )
    }

    fun provideMealDetailsViewModelFactory() : ViewModelProvider.Factory {
        return MealDetailsViewModelFactory(
            repository = ProviderRepository.provideTheMealDbRepository()
        )
    }
}