package br.com.github.guikd.gs_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.github.guikd.gs_kotlin.screens.EquipeScreen
import br.com.github.guikd.gs_kotlin.screens.ImcScreen
import br.com.github.guikd.gs_kotlin.screens.LoginScreen
import br.com.github.guikd.gs_kotlin.screens.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") { LoginScreen(navController) }
                composable("menu") { MenuScreen(navController) }
                composable("imc") { ImcScreen(navController) }
                composable("equipe") { EquipeScreen(navController) }
            }
        }
    }
}
