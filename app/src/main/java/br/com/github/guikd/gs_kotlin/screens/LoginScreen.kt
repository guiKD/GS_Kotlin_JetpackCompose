package br.com.github.guikd.gs_kotlin.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    val usuario = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val erro = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("LOGIN", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = usuario.value,
            onValueChange = { usuario.value = it },
            label = { Text("Usuário") }
        )

        OutlinedTextField(
            value = senha.value,
            onValueChange = { senha.value = it },
            label = { Text("Senha") }
        )

        if (erro.value.isNotEmpty()) {
            Text(erro.value, color = Color.Red)
        }

        Button(onClick = {
            if (usuario.value == "admin" && senha.value == "123456") {
                navController.navigate("menu")
            } else {
                erro.value = "Usuário inválido"
            }
        }) {
            Text("Entrar")
        }
    }
}
