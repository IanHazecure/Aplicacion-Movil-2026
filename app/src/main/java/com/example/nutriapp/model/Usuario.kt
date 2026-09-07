package com.example.nutriapp.model
//anadir herenciaa
class Usuario(
    nombre: String,
    email: String,
    val password: String
) : Persona(nombre, email)