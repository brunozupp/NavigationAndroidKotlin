package com.novelitech.wishlistapp.ui.pages.wishlist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.novelitech.wishlistapp.core.navigation.AppNavigation
import com.novelitech.wishlistapp.data.entities.WishEntity
import com.novelitech.wishlistapp.ui.components.BasePage
import com.novelitech.wishlistapp.ui.components.Gap
import com.novelitech.wishlistapp.ui.pages.wishlist.components.WishCard
import androidx.compose.runtime.getValue
import com.novelitech.wishlistapp.ui.components.AppError
import com.novelitech.wishlistapp.ui.components.AppLoading
import com.novelitech.wishlistapp.ui.components.AppNoContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: WishlistViewModel,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BasePage(
        modifier = modifier,
        title = "Wishlist",
        onClickFloatingActionButton = {
            navController.navigate(
                AppNavigation.NewWish(wish = null)
            )
        }
    ) {
        when {
            uiState.loading -> AppLoading()
            uiState.hasError -> AppError(uiState.error!!)
            uiState.wishes.isEmpty() -> AppNoContent("There is no wish in the list. Please, add one")
            else -> Wishes(
                wishes = uiState.wishes,
                onTapWish = {
                    navController.navigate(
                        AppNavigation.NewWish(wish = it)
                    )
                },
                onSwipeToDismissWish = {
                    viewModel.deleteWish(wish = it)
                }
            )
        }
    }
}

@Composable
private fun Wishes(
    wishes: List<WishEntity>,
    onTapWish: (WishEntity) -> Unit,
    onSwipeToDismissWish: (WishEntity) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
    ) {
        /**
         * When using Dismiss functionality I need to pass the key to work properly
         */
        itemsIndexed(wishes, key = {index, wish -> wish.id}) { index, wish ->
            WishCard(
                wish = wish,
                onTap = onTapWish,
                onSwipeToDismiss = onSwipeToDismissWish,
            )
            if(index < wishes.size - 1) {
                Gap(16)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun WishlistPagePreview() {
//    NavigationAndroidKotlinTheme {
//        WishlistPage()
//    }
//}