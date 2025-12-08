package com.novelitech.navigationandroidkotlin.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.novelitech.navigationandroidkotlin.core.navigation.AppRoutes
import com.novelitech.navigationandroidkotlin.ui.theme.NavigationAndroidKotlinTheme

@Composable
fun FirstScreen(
    navController: NavHostController
) {

    var name by remember {
        mutableStateOf("")
    }

    val isButtonEnabled by remember {
        derivedStateOf { name.isNotBlank() }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Write your name"
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = {
                    name = it
                },
                label = {
                    Text("Name")
                },
            )
            Spacer(
                modifier = Modifier.height(36.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = isButtonEnabled,
                onClick = {
                    navController.navigate(AppRoutes.Second(name = name))
                }
            ) {
                Text(
                    text = "Go to second screen"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {

    val navController = rememberNavController()

    NavigationAndroidKotlinTheme {
        FirstScreen(navController)
    }
}