package com.novelitech.wishlistapp.ui.pages.newwish.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    errorMessage: String? = null
) {

    val hasError = errorMessage != null && errorMessage.isNotBlank()

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(label)
        },
        isError = hasError,
        supportingText = {
            if(hasError) {
                Text(errorMessage)
            }
        }
    )
}