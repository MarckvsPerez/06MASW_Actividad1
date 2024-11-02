package com.example.jetpackapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessDeniedScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Access Denied") })
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Access Denied: Unauthorized User")

                Spacer(modifier = Modifier.height(16.dp))

                // Botón para regresar a la pantalla de bienvenida
                Button(onClick = { navController.popBackStack() }) {
                    Text("Back to Welcome Screen")
                }
            }
        }
    )
}
