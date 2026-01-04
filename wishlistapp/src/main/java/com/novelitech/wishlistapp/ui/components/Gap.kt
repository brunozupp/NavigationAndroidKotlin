package com.novelitech.wishlistapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Gap(gap: Number) {
    Box(
        modifier = Modifier.size(gap.toDouble().dp)
    )
}