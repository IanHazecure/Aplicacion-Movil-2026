package com.example.nutriapp.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Registro : Screen("registro")
    object RecuperarPassword : Screen("recuperar_password")
    object Menu : Screen("menu")
    object Minuta : Screen("minuta")
    object ListaUsuarios : Screen("lista_usuarios")
    object Ayuda : Screen("ayuda")
    object RecetaDetalle : Screen("receta_detalle/{recetaId}") {
        fun createRoute(recetaId: Int) = "receta_detalle/$recetaId"
    }
}
