package com.example.jetpackapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackapp.viewmodel.WelcomeViewModel
import com.example.jetpackapp.R
import com.example.jetpackapp.ui.theme.GrayBackground
import com.example.jetpackapp.ui.theme.OrangeAccent
import com.example.jetpackapp.ui.theme.Purple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel = viewModel(),
    onNavigateToDetail: (String) -> Unit,
    onAccessDenied: () -> Unit
) {
    val welcomeMessage by viewModel.welcomeMessage.observeAsState("")
    var textState by remember { mutableStateOf("") }
<<<<<<< HEAD
    var emailState by remember { mutableStateOf("") }
=======
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Welcome Screen",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo de la aplicación",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = welcomeMessage,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Purple
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = textState,
                    onValueChange = { textState = it },
                    label = { Text("Introduce tu nombre", style = MaterialTheme.typography.bodySmall) },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = OrangeAccent,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onBackground
                    )
                )

<<<<<<< HEAD
                OutlinedTextField(
                    value = emailState,
                    onValueChange = { emailState = it },
                    label = { Text("Introduce tu correo electrónico", style = MaterialTheme.typography.bodySmall) },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = OrangeAccent,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onBackground
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(

                    onClick = {
                        if (textState in listOf("Actividad1") && emailState == "ejemplo@gmail.com") {
=======
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (textState in listOf("Marc", "Amanda", "Mario")) {
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
                            viewModel.updateWelcomeMessage("Bienvenido, $textState")
                            onNavigateToDetail(textState)
                        } else {
                            onAccessDenied()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = OrangeAccent,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
<<<<<<< HEAD

                )
                {
                    Text("Continuar", style = MaterialTheme.typography.bodyLarge)
                }
                if (emailState.isNotEmpty() && emailState != "ejemplo@gmail.com") {
                    Text(
                        text = "El correo electrónico no coincide.",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
=======
                ) {
                    Text("Continuar", style = MaterialTheme.typography.bodyLarge)
                }
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
            }
        }
    )
}
