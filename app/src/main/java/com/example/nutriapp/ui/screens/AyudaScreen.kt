package com.example.nutriapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nutriapp.ui.components.ContenedorAdaptativo

@Composable
fun AyudaScreen(navController: NavHostController) {
    ContenedorAdaptativo {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Ayuda",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            AyudaPaso(
                titulo = "¿Cómo entro a la aplicación?",
                texto = "Escribe tu correo y tu contraseña en la pantalla de inicio, " +
                        "y toca el botón verde \"Iniciar sesión\"."
            )
            AyudaPaso(
                titulo = "¿No tienes cuenta?",
                texto = "Toca el texto \"Regístrate aquí\" en la pantalla de inicio y " +
                        "completa tus datos."
            )
            AyudaPaso(
                titulo = "¿Olvidaste tu contraseña?",
                texto = "Toca \"¿Olvidaste tu contraseña?\" y escribe tu correo para " +
                        "recibir ayuda."
            )
            AyudaPaso(
                titulo = "¿Cómo veo mis recetas?",
                texto = "Una vez dentro, toca el botón \"Ver mi minuta semanal\" y " +
                        "elige una receta para ver sus detalles."
            )
            AyudaPaso(
                titulo = "¿Cómo salgo de la aplicación?",
                texto = "En el menú principal, toca el botón \"Cerrar sesión\"."
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Volver")
            }
        }
    }
}

@Composable
private fun AyudaPaso(titulo: String, texto: String) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(
            text = titulo,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = texto, style = MaterialTheme.typography.bodyLarge)
    }
}

