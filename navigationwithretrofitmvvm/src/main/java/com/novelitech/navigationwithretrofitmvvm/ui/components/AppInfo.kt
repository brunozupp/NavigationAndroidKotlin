package com.novelitech.navigationwithretrofitmvvm.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppInfo(
    modifier: Modifier = Modifier,
    title: String,
    info: String,
) {
    Column(
        modifier
    ) {
        Text(
            title,
            style = TextStyle(
                color = Color(0xFF606060)
            )
        )
        Text(
            info,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        )
    }
}