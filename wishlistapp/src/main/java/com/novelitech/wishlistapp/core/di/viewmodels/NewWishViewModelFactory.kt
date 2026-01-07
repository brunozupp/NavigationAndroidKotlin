package com.novelitech.wishlistapp.core.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.novelitech.wishlistapp.data.repositories.IWishesRepository
import com.novelitech.wishlistapp.ui.pages.newwish.NewWishViewModel

class NewWishViewModelFactory(private val repository: IWishesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewWishViewModel(repository) as T
    }
}