package com.novelitech.navigationwithretrofitmvvm.features.categories.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppGridBasePage
import androidx.compose.runtime.getValue
import com.novelitech.navigationwithretrofitmvvm.core.navigation.AppRoutes
import com.novelitech.navigationwithretrofitmvvm.features.providers.ProviderViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesPage(
    navController: NavController,
    viewModel: CategoriesViewModel,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AppGridBasePage(
        navController = navController,
        appBarTitle = "Categories",
        loading = uiState.loading,
        error = uiState.error,
        items = uiState.categories,
        imageThumb = { it.image },
        imageDescription = { it.name },
        onTapImage = {
            navController.navigate(
                AppRoutes.Meals(categoryName = it.name)
            )
        }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun CategoriesPagePreview() {
//
//    val navController = rememberNavController()
//
//    CategoriesPage(
//        navController = navController,
//        viewModel = ProviderViewModel.provideCategoriesViewModel()
//    )
//}