package com.example.jetpackapp.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = { Text("Settings Screen") },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Settings go here.")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Navigate to other screen */ }) {
                    Text("Save Settings")
                }
            }
        }
    )
}
