package com.novelitech.navigationwithretrofitmvvm.features.providers.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.novelitech.navigationwithretrofitmvvm.features.categories.presentation.CategoriesViewModel
import com.novelitech.navigationwithretrofitmvvm.features.common.data.repositories.themealdb.ITheMealDbRepository
import com.novelitech.navigationwithretrofitmvvm.features.meals.presentation.MealsViewModel

class MealsViewModelFactory(
    private val repository: ITheMealDbRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MealsViewModel(repository) as T
    }
}