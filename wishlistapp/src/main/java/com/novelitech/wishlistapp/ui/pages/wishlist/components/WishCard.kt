package com.novelitech.wishlistapp.ui.pages.wishlist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.novelitech.wishlistapp.data.entities.WishEntity
import com.novelitech.wishlistapp.ui.components.Gap

@Composable
fun WishCard(
    wish: WishEntity,
    onTap: (WishEntity) -> Unit,
    onSwipeToDismiss: (WishEntity) -> Unit,
) {

    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {

            if(it == SwipeToDismissBoxValue.EndToStart) {
                onSwipeToDismiss(wish)
                true
            }

            false
        },
        positionalThreshold = { 0.75f }
    )

    SwipeToDismissBox(
        state = dismissState,
        enableDismissFromStartToEnd = false,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 16.dp))
                    .fillMaxSize()

                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Delete wish",
                    tint = Color.White,
                )
            }
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onTap(wish)
                },
            shape = RoundedCornerShape(size = 16.dp),
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


}