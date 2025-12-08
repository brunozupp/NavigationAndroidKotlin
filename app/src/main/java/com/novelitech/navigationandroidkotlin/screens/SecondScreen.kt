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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.novelitech.navigationandroidkotlin.ui.theme.NavigationAndroidKotlinTheme

@Composable
fun SecondScreen(navController: NavHostController, name: String) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "The name you typed in the first screen is:"
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(
                modifier = Modifier.height(36.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(
                    text = "Go back"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {

    val navController = rememberNavController()

    NavigationAndroidKotlinTheme {
        SecondScreen(navController, "Bruno")
    }
}