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
<<<<<<< HEAD
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
=======
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackapp.viewmodel.DetailViewModel
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
import androidx.navigation.NavController
import com.example.jetpackapp.R
import com.example.jetpackapp.ui.theme.GrayBackground
import com.example.jetpackapp.ui.theme.OrangeAccent
import com.example.jetpackapp.ui.theme.Purple
<<<<<<< HEAD
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
=======
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    userName: String,
    viewModel: DetailViewModel = viewModel()
) {
    val detailText by viewModel.detailText.observeAsState("")
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
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
<<<<<<< HEAD
                verticalArrangement = Arrangement.Top,
=======
                verticalArrangement = Arrangement.Center,
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                // Saludo al usuario
                Text(
<<<<<<< HEAD
                    text = "Hola, $userName",
=======
                    text = stringResource(R.string.greeting_text, userName),
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
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

<<<<<<< HEAD
                // Campo de entrada para añadir la hora como String
                OutlinedTextField(
                    value = newTime,
                    onValueChange = { newTime = it },
                    label = { Text("Introduce la hora (HH:mm)") },
=======
                // Campo de entrada para añadir la hora en la que se desea llegar al destino
                OutlinedTextField(
                    value = newTime,
                    onValueChange = { newTime = it },
                    label = { Text(stringResource(R.string.add_detail_placeholder2)) },
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        if (newDetail.isNotBlank() && newTime.isNotBlank()) {
<<<<<<< HEAD
                            // Comprobar si la hora tiene el formato correcto
=======
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
                            val timeParts = newTime.split(":")
                            if (timeParts.size == 2) {
                                val hours = timeParts[0].toIntOrNull()
                                val minutes = timeParts[1].toIntOrNull()
<<<<<<< HEAD
                                if (hours != null && minutes != null && hours in 0..23 && minutes in 0..59) {
                                    // Añadir detalle y hora como String
                                    viewModel.addDetail(newDetail, newTime)
=======
                                if (hours != null && minutes != null) {
                                    // Crear LocalTime
                                    val localTime = LocalTime.of(hours, minutes)
                                    // Añadir detalle y hora
                                    viewModel.addDetail(newDetail, localTime)
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
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

<<<<<<< HEAD
                // Diálogo de error si es necesario
=======
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
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

<<<<<<< HEAD
                // Título de la lista de lugares !!!!
                Text(
                    text = "Lista de lugares",
                    style = MaterialTheme.typography.titleMedium,
                    color = Purple,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

=======
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
                // Lista de detalles usando LazyColumn
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(detailsList) { (detail, time) ->
<<<<<<< HEAD
                        Text(
                            text = "$detail - $time",
=======
                        // Mostrar tanto el detalle como la hora
                        Text(
                            text = "$detail - ${String.format("%02d:%02d", time.hour, time.minute)}", // Formato "HH:mm"
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
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
<<<<<<< HEAD


=======
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
