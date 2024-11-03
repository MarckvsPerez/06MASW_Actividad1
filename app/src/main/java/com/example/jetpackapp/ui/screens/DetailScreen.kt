package com.example.jetpackapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jetpackapp.R
import com.example.jetpackapp.ui.theme.GrayBackground
import com.example.jetpackapp.ui.theme.OrangeAccent
import com.example.jetpackapp.ui.theme.Purple
import com.example.jetpackapp.viajesBD.SQLiteHelper
import com.example.jetpackapp.viewmodel.DetailViewModel
import com.example.jetpackapp.viewmodel.DetailViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)


@Composable

fun DetailScreen(
    navController: NavController,
    userName: String,
    viewModel: DetailViewModel = viewModel(factory = DetailViewModelFactory(SQLiteHelper(LocalContext.current)))
) {
    val detailsList by viewModel.detailsList.observeAsState(emptyList())
    var newDetail by remember { mutableStateOf("") }
    var newTime by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.detail_screen_title),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back_button_text),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = OrangeAccent,
                    titleContentColor = GrayBackground
                )
            )
        },
        content = { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                // Saludo al usuario
                Text(
                    text = "Hola, $userName",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Purple
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Campo de entrada para añadir un nuevo destino
                OutlinedTextField(
                    value = newDetail,
                    onValueChange = { newDetail = it },
                    label = { Text(stringResource(R.string.add_detail_placeholder)) },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Campo de entrada para añadir la hora como String
                OutlinedTextField(
                    value = newTime,
                    onValueChange = { newTime = it },
                    label = { Text("Introduce la hora (HH:mm)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        if (newDetail.isNotBlank() && newTime.isNotBlank()) {
                            // Comprobar si la hora tiene el formato correcto
                            val timeParts = newTime.split(":")
                            if (timeParts.size == 2) {
                                val hours = timeParts[0].toIntOrNull()
                                val minutes = timeParts[1].toIntOrNull()
                                if (hours != null && minutes != null && hours in 0..23 && minutes in 0..59) {
                                    // Añadir detalle y hora como String
                                    viewModel.addDetail(newDetail, newTime)
                                    newDetail = ""
                                    newTime = ""
                                } else {
                                    dialogMessage = "Formato de hora inválido. Usa HH:mm."
                                    showDialog = true
                                }
                            } else {
                                dialogMessage = "Formato de hora inválido. Usa HH:mm."
                                showDialog = true
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = OrangeAccent,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(stringResource(R.string.submit_button), style = MaterialTheme.typography.bodyLarge)
                }

                // Diálogo de error si es necesario
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Error") },
                        text = { Text(dialogMessage) },
                        confirmButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("OK")
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Título de la lista de lugares
                Text(
                    text = "Lista de lugares",
                    style = MaterialTheme.typography.titleMedium,
                    color = Purple,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Lista de detalles usando LazyColumn
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(detailsList) { (detail, time) ->
                        Text(
                            text = "$detail - $time",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .background(MaterialTheme.colorScheme.surface)
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    )
}


