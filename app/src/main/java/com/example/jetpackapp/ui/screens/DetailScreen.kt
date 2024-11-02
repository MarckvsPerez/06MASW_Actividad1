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
fun DetailScreen(
    navController: NavController,
    userName: String // Recibimos el nombre como parámetro
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detail Screen") })
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
                // Mostrar el nombre que se ingresó en WelcomeScreen
                Text(text = "Hola, $userName!")

                Spacer(modifier = Modifier.height(16.dp))

                // Botón para regresar a la pantalla anterior
                Button(onClick = { navController.popBackStack() }) {
                    Text("Back")
                }
            }
        }
    )
}
