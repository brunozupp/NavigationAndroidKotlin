package com.novelitech.navigationwithretrofitmvvm.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppGap(gap: Double) {
    Box(
        modifier = Modifier
            .size(gap.dp)
    )
}