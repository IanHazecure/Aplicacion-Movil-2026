package com.example.nutriapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nutriapp.ui.screens.LoginScreen
import com.example.nutriapp.ui.screens.MinutaScreen
import com.example.nutriapp.ui.screens.RecetaDetalleScreen
import com.example.nutriapp.ui.screens.RecuperarPasswordScreen
import com.example.nutriapp.ui.screens.RegistroScreen
import com.example.nutriapp.ui.screens.ListaUsuariosScreen
import com.example.nutriapp.ui.screens.MenuScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Registro.route) {
            RegistroScreen(navController)
        }

        composable(Screen.RecuperarPassword.route) {
            RecuperarPasswordScreen(navController)
        }
        composable(Screen.Minuta.route) {
            MinutaScreen(navController)
        }
        composable(
            route = Screen.RecetaDetalle.route,
            arguments = listOf(navArgument("recetaId") { type = NavType.IntType })
        ) { backStackEntry ->
            val recetaId = backStackEntry.arguments?.getInt("recetaId") ?: -1
            RecetaDetalleScreen(navController, recetaId)
        }

        composable(Screen.Menu.route) {
            MenuScreen(navController)
        }

        composable(Screen.Minuta.route) {
            MinutaScreen(navController)
        }

        composable(Screen.ListaUsuarios.route) {
            ListaUsuariosScreen(navController)
        }

    }
}