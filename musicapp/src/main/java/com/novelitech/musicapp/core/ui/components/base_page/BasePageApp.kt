package com.novelitech.musicapp.core.ui.components.base_page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import com.novelitech.musicapp.core.ui.theme.ColorsApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasePageApp(
    title: String = "",
    onTapBackIcon: (() -> Unit)? = null,
    onTapLeadingIcon: (() -> Unit)? = null,
    leadingIcon: ImageVector? = null,
    margin: PaddingValues? = null,
    content: @Composable () -> Unit,
) {

    val showBackIcon = onTapBackIcon != null
    val showLeadingIcon = onTapLeadingIcon != null && leadingIcon != null

    Scaffold(
        containerColor = ColorsApp.Background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = ColorsApp.Primary,
                ),
                title = {
                    Text(
                        title,
                        style = TextStyle(
                            color = ColorsApp.TextOnPrimary
                        )
                    )
                },
                navigationIcon = {
                    when {
                        showLeadingIcon -> {
                            Icon(
                                imageVector = leadingIcon,
                                contentDescription = "Leading icon",
                                tint = ColorsApp.TextOnPrimary,
                            )
                        }
                        showBackIcon -> {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Navigation back",
                                tint = ColorsApp.TextOnPrimary,
                            )
                        }
                    }
                }
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .padding(margin ?: PaddingValues.Zero)
        ) {
            content()
        }
    }
}