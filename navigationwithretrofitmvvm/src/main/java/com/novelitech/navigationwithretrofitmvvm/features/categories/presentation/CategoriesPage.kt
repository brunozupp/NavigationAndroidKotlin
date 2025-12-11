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
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppGridBasePage
import com.novelitech.navigationwithretrofitmvvm.ui.components.AppTopAppBar
import com.novelitech.navigationwithretrofitmvvm.ui.theme.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesPage(
    navController: NavController
) {

    AppGridBasePage<String>(
        navController = navController,
        appBarTitle = "Categories",
        loading = false,
        error = null,
        items = listOf<String>("bruno", "pedro", "carlos"),
        imageThumb = { "https://assets.multiplan.com.br/Multiplan/filer_public/08/1e/081e570e-5fc2-47a1-a72d-21d299b4562d/comidas-tipicas-brasileiras-no-analia.webp?ims=1920x" },
        imageDescription = { it },
        onTapImage = {  }
    )
}

@Preview(showBackground = true)
@Composable
fun CategoriesPagePreview() {

    val navController = rememberNavController()

    CategoriesPage(
        navController = navController
    )
}