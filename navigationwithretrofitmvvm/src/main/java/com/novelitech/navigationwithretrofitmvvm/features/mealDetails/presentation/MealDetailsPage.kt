package com.novelitech.navigationwithretrofitmvvm.features.mealDetails.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.novelitech.navigationwithretrofitmvvm.features.categories.presentation.CategoriesPage
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppChip
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppExpandable
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppGap
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppInfo
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppTopAppBar
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.novelitech.navigationwithretrofitmvvm.ui.components.ErrorPage
import com.novelitech.navigationwithretrofitmvvm.ui.components.LoadingPage
import com.novelitech.navigationwithretrofitmvvm.ui.components.NoContentPage

@Composable
fun MealDetailsPage(
    navController: NavController,
    viewModel: MealDetailsViewModel,
    mealId: String,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var canExecuteFirstTime by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        if(canExecuteFirstTime) {
            viewModel.fetchDetails(mealId)
            canExecuteFirstTime = false
        }
    }

    Scaffold(
        topBar = {
            AppTopAppBar(
                navController = navController,
                title = "",
            )
        }
    ) { innerPadding ->

        when {
            uiState.loading -> {
                LoadingPage()
            }
            uiState.error != null && uiState.error!!.isNotBlank() -> {
                ErrorPage(
                    error = uiState.error!!,
                )
            }
            uiState.details != null -> {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(24.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        AppInfo(
                            modifier = Modifier
                                .weight(1f),
                            title = "Name",
                            info = uiState.details!!.name
                        )
                        AppChip(
                            title = uiState.details!!.category,
                        )
                    }
                    AppGap(
                        gap = 16.0
                    )
                    AppInfo(
                        title = "Nationality",
                        info = uiState.details!!.area
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    AppExpandable(
                        title = "Ingredients",
                        startExpanded = true
                    ) {
                        LazyColumn {
                            items(uiState.details!!.ingredients) {
                                Text(
                                    "- $it",
                                    style = TextStyle(
                                        fontSize = 16.sp
                                    )
                                )
                            }
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    AppExpandable(
                        title = "Instructions",
                        startExpanded = true
                    ) {
                        Text(
                            "Hey",
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }
            else -> {
                NoContentPage()
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun CategoriesPagePreview() {
//
//    val navController = rememberNavController()
//
//    MealDetailsPage(
//        navController = navController,
//    )
//}