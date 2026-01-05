package com.novelitech.wishlistapp.ui.pages.newwish

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.novelitech.wishlistapp.ui.components.AppError
import com.novelitech.wishlistapp.ui.components.AppLoading
import com.novelitech.wishlistapp.ui.components.BasePage
import com.novelitech.wishlistapp.ui.components.Gap
import com.novelitech.wishlistapp.ui.pages.newwish.components.AppField
import com.novelitech.wishlistapp.ui.theme.Colors

@Composable
fun NewWishPage(
    modifier: Modifier = Modifier,
    viewModel: NewWishViewModel,
    navController: NavController,
) {

    val scrollState = rememberScrollState()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BasePage(
        modifier = modifier,
        title = "Wish",
        onClickNavigationBack = {
            navController.popBackStack()
        }
    ) {
        when {
            uiState.loading -> AppLoading()
            uiState.hasError -> AppError(uiState.error!!)
            else -> NewWish(
                viewModel = viewModel,
                uiState = uiState,
                scrollState = scrollState,
            )
        }
    }
}

@Composable
private fun NewWish(
    viewModel: NewWishViewModel,
    uiState: NewWishUiState,
    scrollState: ScrollState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        AppField(
            value = uiState.title,
            onValueChange = viewModel::onChangeTitle,
            label = "Title",
            errorMessage = uiState.titleError,
        )
        Gap(8)
        AppField(
            value = uiState.description,
            onValueChange = viewModel::onChangeDescription,
            label = "Description",
            errorMessage = uiState.descriptionError,
        )
        Gap(16)
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            enabled = uiState.isFormValid,
            onClick = {

            },
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Colors.Primaria
            )
        ) {
            Text(
                "Save"
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun NewWishPagePreview() {
//    NavigationAndroidKotlinTheme {
//        NewWishPage()
//    }
//}