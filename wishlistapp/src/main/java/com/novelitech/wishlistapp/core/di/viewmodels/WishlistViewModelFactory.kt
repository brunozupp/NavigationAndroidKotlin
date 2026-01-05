package com.novelitech.wishlistapp.core.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.novelitech.wishlistapp.ui.pages.wishlist.WishlistViewModel

class WishlistViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WishlistViewModel() as T
    }
}