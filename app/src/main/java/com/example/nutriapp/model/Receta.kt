package com.example.nutriapp.model


data class Receta(
    val id: String = "",
    val dia: String = "",
    val nombre: String = "",
    val descripcion: String = "",
    val calorias: Int = 0,
    val proteinasG: Int = 0,
    val carbohidratosG: Int = 0,
    val grasasG: Int = 0,
    val recomendacion: String = ""
)