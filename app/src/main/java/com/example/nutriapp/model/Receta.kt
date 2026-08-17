package com.example.nutriapp.model


data class Receta(
    val id: Int,
    val dia: String,
    val nombre: String,
    val descripcion: String,
    val calorias: Int,
    val proteinasG: Int,
    val carbohidratosG: Int,
    val grasasG: Int,
    val recomendacion: String
)
