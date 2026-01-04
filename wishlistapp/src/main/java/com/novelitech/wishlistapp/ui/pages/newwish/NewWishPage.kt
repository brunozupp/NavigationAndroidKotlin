package com.novelitech.wishlistapp.ui.pages.newwish

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novelitech.wishlistapp.ui.components.BasePage
import com.novelitech.wishlistapp.ui.components.Gap
import com.novelitech.wishlistapp.ui.pages.newwish.components.AppField
import com.novelitech.wishlistapp.ui.theme.Colors
import com.novelitech.wishlistapp.ui.theme.NavigationAndroidKotlinTheme

@Composable
fun NewWishPage(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    BasePage(
        modifier = modifier,
        title = "Wish"
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            AppField(
                value = title,
                onValueChange = {
                    title = it
                },
                label = "Title"
            )
            Gap(8)
            AppField(
                value = description,
                onValueChange = {
                    description = it
                },
                label = "Description"
            )
            Gap(16)
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
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
}

@Preview(showBackground = true)
@Composable
fun NewWishPagePreview() {
    NavigationAndroidKotlinTheme {
        NewWishPage()
    }
}