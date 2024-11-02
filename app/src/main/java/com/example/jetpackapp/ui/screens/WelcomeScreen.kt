package com.example.jetpackapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackapp.viewmodel.WelcomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel = viewModel(),
    onNavigateToDetail: (String) -> Unit // Pasar el nombre del usuario a DetailScreen
) {
    val welcomeMessage by viewModel.welcomeMessage.observeAsState("")
    var textState by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Welcome Screen") })
        },
        content = { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text(text = welcomeMessage) // Mostrar el mensaje de bienvenida

                // Campo de texto para el nombre del usuario
                OutlinedTextField(
                    value = textState,
                    onValueChange = { textState = it }, // Actualiza el estado local
                    label = { Text("Introduce tu nombre") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botón de continuar
                Button(onClick = {
                    viewModel.updateWelcomeMessage("Bienvenido, $textState")
                    onNavigateToDetail(textState) // Pasar el nombre al navegar
                }) {
                    Text("Continuar")
                }
            }
        }
    )
}
