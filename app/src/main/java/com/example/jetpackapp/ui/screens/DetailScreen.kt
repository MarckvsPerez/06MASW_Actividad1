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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackapp.viewmodel.DetailViewModel
import androidx.navigation.NavController
import com.example.jetpackapp.R
import com.example.jetpackapp.ui.theme.GrayBackground
import com.example.jetpackapp.ui.theme.OrangeAccent
import com.example.jetpackapp.ui.theme.Purple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    userName: String,
    viewModel: DetailViewModel = viewModel()
) {
    val detailText by viewModel.detailText.observeAsState("")
    val detailsList by viewModel.detailsList.observeAsState(emptyList())
    var newDetail by remember { mutableStateOf("") }

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
                        color = Color.White
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
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                // Saludo al usuario
                Text(
                    text = stringResource(R.string.greeting_text, userName),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Purple
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Campo de entrada para añadir un nuevo detalle
                OutlinedTextField(
                    value = newDetail,
                    onValueChange = { newDetail = it },
                    label = { Text(stringResource(R.string.add_detail_placeholder)) },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        if (newDetail.isNotBlank()) {
                            viewModel.addDetail(newDetail)
                            newDetail = ""
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = OrangeAccent,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(stringResource(R.string.submit_button), style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Lista de detalles usando LazyColumn
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(detailsList) { detail ->
                        Text(
                            text = detail,
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
