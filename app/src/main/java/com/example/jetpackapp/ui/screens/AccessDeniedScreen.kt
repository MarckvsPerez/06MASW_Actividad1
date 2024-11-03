package com.example.jetpackapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackapp.ui.theme.GrayBackground
import com.example.jetpackapp.ui.theme.OrangeAccent
import com.example.jetpackapp.ui.theme.Purple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessDeniedScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Acceso Denegado",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = OrangeAccent,
                    titleContentColor = GrayBackground
                )
            )
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
                Text(
                    text = "Acceso denegado: Usuario no autorizado",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Purple
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = OrangeAccent,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text("Volver a la pantalla de bienvenida", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    )
}
