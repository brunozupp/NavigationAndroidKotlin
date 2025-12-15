package com.novelitech.navigationwithretrofitmvvm.features.meals.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppGridBasePage
import androidx.compose.runtime.setValue

@Composable
fun MealsPage(
    navController: NavController,
    viewModel: MealsViewModel,
    categoryName: String,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var canExecuteFirstTime by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        if (canExecuteFirstTime) {
            viewModel.fetchMeals(categoryName)
            canExecuteFirstTime = false
        }
    }

    AppGridBasePage(
        navController = navController,
        appBarTitle = "Meals",
        loading = uiState.loading,
        error = uiState.error,
        items = uiState.meals,
        imageThumb = { it.image },
        imageDescription = { it.name },
        onTapImage = { println("${it.name}") }
    )
}