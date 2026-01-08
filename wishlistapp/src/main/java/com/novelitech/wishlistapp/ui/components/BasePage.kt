package com.novelitech.wishlistapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.novelitech.wishlistapp.ui.theme.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasePage(
    modifier: Modifier = Modifier,
    title: String,
    onClickFloatingActionButton: (() -> Unit)? = null,
    onClickNavigationBack: (() -> Unit)? = null,
    snackbarHost: @Composable (() -> Unit) = {},
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
          if(onClickFloatingActionButton != null) {
              AppFloatingActionButton(onClickFloatingActionButton)
          }
        },
        snackbarHost = snackbarHost,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        title,
                        style = TextStyle(
                            color = Colors.Texto,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = Colors.Primaria,
                ),
                navigationIcon = {
                    if(onClickNavigationBack != null) {
                        AppNavigationBackIcon(onClickNavigationBack)
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            content()
        }
    }
}

@Composable
private fun AppFloatingActionButton(
    onClick: () -> Unit,
) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = Colors.Primaria,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add"
        )
    }
}

@Composable
fun AppNavigationBackIcon(
    onClick: () -> Unit,
) {
    Icon(
        modifier = Modifier
            .clickable { onClick() },
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = "Go back",
    )
}