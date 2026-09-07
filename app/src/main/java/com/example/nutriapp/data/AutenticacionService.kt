package com.example.nutriapp.data

import com.example.nutriapp.model.Usuario

sealed class ResultadoAuth {
    object Exito : ResultadoAuth()
    data class Error(val mensaje: String) : ResultadoAuth()
}

class AutenticacionService(
    private val repositorio: UsuariosRepository = UsuariosRepository.instancia
) {

}