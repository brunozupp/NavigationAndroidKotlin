package com.novelitech.navigationwithretrofitmvvm.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.novelitech.navigationwithretrofitmvvm.ui.theme.Colors

@Composable
fun AppChip(
    title: String,
) {
    Box(
        modifier = Modifier
            .dropShadow(
                shape = RoundedCornerShape(16.dp),
                shadow = Shadow(
                    radius = 1.dp,
                    color = Color(0x40000000),
                    offset = DpOffset(
                        x = 1.dp,
                        y = 1.dp
                    )
                )
            )
            .background(Colors.Secondary, shape = RoundedCornerShape(16.dp))
    ) {
        Text(
            title,
            modifier = Modifier.padding(8.dp)
        )
    }
}