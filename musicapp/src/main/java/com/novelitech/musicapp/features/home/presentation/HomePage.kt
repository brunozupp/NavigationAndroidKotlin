package com.novelitech.musicapp.features.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novelitech.musicapp.core.ui.components.base_page.BasePageApp
import com.novelitech.musicapp.core.ui.components.base_page.BasePageWithScrollApp
import com.novelitech.musicapp.core.ui.theme.NavigationAndroidKotlinTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier) {

    BasePageWithScrollApp(
        title = "Home",
        margin = PaddingValues(16.dp)
    ) {
        Column() {
            Text("Texto improvisado")
            for (i in 1..40) {
                Text("Texto improvisado $i")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text("Texto improvisado final")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    NavigationAndroidKotlinTheme() {
        HomePage()
    }
}