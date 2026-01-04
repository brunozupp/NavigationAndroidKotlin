package com.novelitech.wishlistapp.ui.pages.wishlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.novelitech.wishlistapp.core.navigation.AppNavigation
import com.novelitech.wishlistapp.data.models.WishModel
import com.novelitech.wishlistapp.ui.components.BasePage
import com.novelitech.wishlistapp.ui.components.Gap
import com.novelitech.wishlistapp.ui.pages.wishlist.components.WishCard
import com.novelitech.wishlistapp.ui.theme.Colors
import com.novelitech.wishlistapp.ui.theme.NavigationAndroidKotlinTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistPage(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val wishes = listOf<WishModel>(
        WishModel("Title one", "Description one"),
        WishModel("Title two", "Description two"),
        WishModel("Title three", "Description three"),
        WishModel("Title four", "Description four"),
        WishModel("Title five", "Description five"),
        WishModel("Title six", "Description six"),
    )

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
            itemsIndexed(wishes) { index, wish ->
                WishCard(wish)
                if(index < wishes.size - 1) {
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