package com.novelitech.navigationwithretrofitmvvm.features.categories.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppTopAppBar
import com.novelitech.navigationwithretrofitmvvm.ui.theme.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesPage(
    navController: NavController
) {

    val loading = false
//    val error: String? = "Some error here"
    val error: String? = null
    val list = mutableListOf<String>("bruno", "pedro", "carlos")

    Scaffold(
        topBar = {
            AppTopAppBar(
                navController = navController,
                title = "Categories"
            )
        },
        containerColor = Color.White,
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            when {
                loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                }
                error != null -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "Error!",
                            )
                            Text(
                                text = error,
                            )
                        }
                    }
                }
                list.isNotEmpty() -> {
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(list) {
                            Box(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                AsyncImage(
                                    model = "https://www.gastronomia.com.br/wp-content/uploads/2024/01/comida-com-f-feijoada-falafel-fondue-e-muito-mais.jpg",
                                    contentDescription = "Comida",
                                    modifier = Modifier.fillMaxSize().aspectRatio(1f),
                                    contentScale = ContentScale.Crop
                                )
//                                Box(
//                                    modifier = Modifier.fillMaxSize().aspectRatio(1f).background(color = Colors.Purple40)
//                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Black.copy(alpha = 0.7f))
                                        .align(Alignment.BottomCenter),
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                horizontal = 8.dp,
                                                vertical = 12.dp,
                                            ),
                                        text = "Comida",
                                        style = TextStyle(
                                            color = Color.White,
                                        ),
                                        textAlign = TextAlign.Center,
                                    )
                                }
                            }
                        }
                    }
                }
                else -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "No content!",
                        )
                        Text(
                            text = "There is no content to display :|",
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesPagePreview() {

    val navController = rememberNavController()

    CategoriesPage(
        navController = navController
    )
}