package com.novelitech.navigationwithretrofitmvvm.features.mealDetails.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppChip
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppExpandable
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppGap
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppInfo
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppTopAppBar
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppErrorPage
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppLoadingPage
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppNoContentPage
import com.novelitech.navigationwithretrofitmvvm.ui.theme.Colors

@Composable
fun MealDetailsPage(
    navController: NavController,
    viewModel: MealDetailsViewModel,
    mealId: String,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    /**
     * By default, a Column is not scrollable. So, I need to pass this to the property verticalScroll
     * from Modifier's Column. And import to know: when working with this approach I can not have
     * ColumnLazy nested inside a scrollable Column.
     * If for some motive I have a really large list of items I can wrap all my content inside a
     * LazyColumn and I don't need to use .verticalScroll with this approach
     */
    val scrollState = rememberScrollState()

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
                AppLoadingPage()
            }
            uiState.error != null && uiState.error!!.isNotBlank() -> {
                AppErrorPage(
                    error = uiState.error!!,
                )
            }
            uiState.details != null -> {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(innerPadding)
                        .padding(24.dp)
                        .fillMaxSize()
                        .verticalScroll(scrollState)
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
                    AppGap(
                        gap = 16.0,
                    )
                    if(uiState.details!!.tags.isNotEmpty()) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            uiState.details!!.tags.forEach {
                                AppChip(it)
                            }
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    AppExpandable(
                        title = "Ingredients",
                        startExpanded = true
                    ) {
                        uiState.details!!.ingredients.forEach {
                            Text(
                                "* $it",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Colors.InfoText,
                                )
                            )
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
                            uiState.details!!.instructions,
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Colors.InfoText,
                            )
                        )
                    }
                }
            }
            else -> {
                AppNoContentPage()
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