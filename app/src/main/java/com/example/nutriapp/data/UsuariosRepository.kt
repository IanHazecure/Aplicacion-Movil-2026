package com.example.nutriapp.data

import androidx.compose.runtime.mutableStateListOf
import com.example.nutriapp.model.Usuario

class UsuariosRepository private constructor() {

    private val usuarios = mutableStateListOf( ///*****
        Usuario("Felipe Ruz", "felipe@gmail.com", "pass123"),
        Usuario("Camila Rojas", "camila@gmail.com", "pass123"),
        Usuario("Ignacio Pérez", "ignacio@gmail.com", "pass123"),
        Usuario("Valentina Navarro", "valentina@gmail.com", "pass123"),
        Usuario("Diego Fuentes", "diego@gmail.com", "pass123")
    )

    fun obtenerUsuarios(): List<Usuario> = usuarios

    fun validar(email: String, password: String): Usuario? {
        return usuarios.find { it.email == email && it.password == password }
    }

    fun existeEmail(email: String): Boolean {
        return usuarios.any { it.email == email }
    }

    fun alcanzoLimite(): Boolean {
        return usuarios.size >= MAX_USUARIOS
    }

    fun registrar(usuario: Usuario) {
        usuarios.add(usuario)
    }

    companion object {
        const val MAX_USUARIOS = 5
        val instancia: UsuariosRepository by lazy { UsuariosRepository() }
    }
}
