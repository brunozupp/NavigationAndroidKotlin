package com.novelitech.wishlistapp.core.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.novelitech.wishlistapp.ui.pages.newwish.NewWishViewModel

class NewWishViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewWishViewModel() as T
    }
}