package br.com.github.guikd.gs_kotlin.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.github.guikd.gs_kotlin.calcularImc

@Composable
fun ImcScreen(navController: NavController) {

    val nome = remember { mutableStateOf("") }
    val peso = remember { mutableStateOf("") }
    val altura = remember { mutableStateOf("") }
    val resultado = remember { mutableStateOf("") }

    Column(Modifier.padding(32.dp)) {

        Text("Calculadora IMC", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = nome.value,
            onValueChange = { nome.value = it },
            label = { Text("Seu nome") }
        )

        OutlinedTextField(
            value = peso.value,
            onValueChange = { peso.value = it },
            label = { Text("Peso") }
        )

        OutlinedTextField(
            value = altura.value,
            onValueChange = { altura.value = it },
            label = { Text("Altura (cm)") }
        )

        Button(onClick = {
            val imc = calcularImc(
                altura.value.toDouble(),
                peso.value.toDouble()
            )
            resultado.value = "${nome.value}, seu IMC é %.1f".format(imc)
        }) {
            Text("Calcular")
        }

        Text(resultado.value)

        Button(onClick = { navController.navigate("menu") }) {
            Text("Voltar")
        }
    }
}
