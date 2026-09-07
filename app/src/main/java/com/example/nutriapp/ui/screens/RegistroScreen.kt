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

