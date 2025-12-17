package com.novelitech.navigationwithretrofitmvvm.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> AppGridBasePage(
    navController: NavController,
    appBarTitle: String?,
    loading: Boolean,
    error: String?,
    items: List<T>,
    imageThumb: (T) -> String,
    imageDescription: (T) -> String,
    onTapImage: (T) -> Unit,
) {

    Scaffold(
        topBar = {
            AppTopAppBar(
                navController = navController,
                title = appBarTitle ?: ""
            )
        },
        containerColor = Color.White,
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            when {
                loading -> {
                    AppLoadingPage()
                }
                error != null -> {
                    AppErrorPage(
                        error = error,
                    )
                }
                items.isNotEmpty() -> {
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(items) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        onTapImage(it)
                                    }
                            ) {
                                AsyncImage(
                                    model = imageThumb(it),
                                    contentDescription = imageDescription(it),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .aspectRatio(1f),
                                    contentScale = ContentScale.Crop
                                )
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
                                        text = imageDescription(it),
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
                    AppNoContentPage()
                }
            }
        }
    }
}