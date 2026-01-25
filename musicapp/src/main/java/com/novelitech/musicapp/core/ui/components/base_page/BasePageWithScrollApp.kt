package com.novelitech.musicapp.core.ui.components.base_page

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BasePageWithScrollApp(
    title: String = "",
    onTapBackIcon: (() -> Unit)? = null,
    onTapLeadingIcon: (() -> Unit)? = null,
    leadingIcon: ImageVector? = null,
    margin: PaddingValues? = null,
    content: @Composable () -> Unit,
) {

    val scrollState = rememberScrollState()

    BasePageApp(
        title = title,
        onTapBackIcon = onTapBackIcon,
        onTapLeadingIcon = onTapLeadingIcon,
        leadingIcon = leadingIcon,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(margin ?: PaddingValues.Zero)
        ) {
            content()
        }
    }
}