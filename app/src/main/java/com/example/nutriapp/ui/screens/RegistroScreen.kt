package com.example.nutriapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nutriapp.data.UsuariosRepository
import com.example.nutriapp.model.Usuario
import com.example.nutriapp.navigation.Screen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PersonAdd
import com.example.nutriapp.ui.components.ContenedorAdaptativo
import com.example.nutriapp.ui.components.MensajeError

@OptIn(ExperimentalMaterial3Api::class) //hay que agregar esto al parecer y arregla el errorlol
@Composable
fun RegistroScreen(navController: NavHostController) {
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val objetivos = listOf("Bajar de peso", "Mantener peso", "Subir masa muscular")
    var objetivoSeleccionado by remember { mutableStateOf(objetivos[0]) }
    var expanded by remember { mutableStateOf(false) }

    val opcionesSexo = listOf("Femenino", "Masculino", "Otro")
    var sexoSeleccionado by remember { mutableStateOf(opcionesSexo[0]) }

    var aceptaTerminos by remember { mutableStateOf(false) }

    var errorMsg by remember { mutableStateOf<String?>(null) }

    val cupoLleno = UsuariosRepository.alcanzoLimite()

    ContenedorAdaptativo {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            Text(
                text = "Crear cuenta",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (cupoLleno) {
                MensajeError("Se alcanzó el máximo de ${UsuariosRepository.MAX_USUARIOS} usuarios registrados. No es posible crear más cuentas.")
                Spacer(modifier = Modifier.height(16.dp))
            }

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre completo") },
                singleLine = true,
                enabled = !cupoLleno,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") },
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null) },
                singleLine = true,
                enabled = !cupoLleno,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
                singleLine = true,
                enabled = !cupoLleno,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirmar contraseña") },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
                singleLine = true,
                enabled = !cupoLleno,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Objetivo nutricional", style = MaterialTheme.typography.labelLarge)
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { if (!cupoLleno) expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = objetivoSeleccionado,
                    onValueChange = {},
                    readOnly = true,
                    enabled = !cupoLleno,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    objetivos.forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion) },
                            onClick = {
                                objetivoSeleccionado = opcion
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Sexo", style = MaterialTheme.typography.labelLarge)
            opcionesSexo.forEach { opcion ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RadioButton(
                        selected = sexoSeleccionado == opcion,
                        onClick = { sexoSeleccionado = opcion },
                        enabled = !cupoLleno
                    )
                    Text(text = opcion)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = aceptaTerminos,
                    onCheckedChange = { aceptaTerminos = it },
                    enabled = !cupoLleno
                )
                Text(text = "Acepto los términos y condiciones")
            }

            errorMsg?.let {
                Spacer(modifier = Modifier.height(12.dp))
                MensajeError(it)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    errorMsg = when {
                        nombre.isBlank() || email.isBlank() || password.isBlank() ->
                            "Completa todos los campos"
                        password != confirmPassword -> "Las contraseñas no coinciden"
                        UsuariosRepository.existeEmail(email) -> "Ese correo ya está registrado"
                        !aceptaTerminos -> "Debes aceptar los términos y condiciones"
                        else -> null
                    }
                    if (errorMsg == null) {
                        UsuariosRepository.registrar(Usuario(nombre, email, password))
                        navController.navigate(Screen.Menu.route) {
                            popUpTo(Screen.Login.route) { inclusive = true }
                        }
                    }
                },
                enabled = !cupoLleno,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(Icons.Filled.PersonAdd, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Registrarme")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ya tengo cuenta, iniciar sesión")
            }
        }
    }
}