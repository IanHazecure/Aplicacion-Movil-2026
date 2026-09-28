package com.example.nutriapp.model

data class Minuta(
    val id: String = "",
    val semana: String = "",
    val recetasPorDia: Map<String, String> = emptyMap()
)