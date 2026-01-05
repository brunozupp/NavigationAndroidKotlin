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
import com.novelitech.wishlistapp.data.models.WishModel
import com.novelitech.wishlistapp.ui.components.BasePage
import com.novelitech.wishlistapp.ui.components.Gap
import com.novelitech.wishlistapp.ui.pages.wishlist.components.WishCard
import androidx.compose.runtime.getValue

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
                AppNavigation.NewWish
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
        ) {
            itemsIndexed(uiState.wishes) { index, wish ->
                WishCard(wish)
                if(index < uiState.wishes.size - 1) {
                    Gap(16)
                }
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