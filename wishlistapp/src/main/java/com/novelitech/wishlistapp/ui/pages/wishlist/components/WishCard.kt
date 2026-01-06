package com.novelitech.wishlistapp.ui.pages.wishlist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.novelitech.wishlistapp.data.entities.WishEntity
import com.novelitech.wishlistapp.ui.components.Gap

@Composable
fun WishCard(
    wish: WishEntity
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                wish.title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                )
            )
            Gap(4)
            Text(
                wish.description,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                )
            )
        }
    }
}