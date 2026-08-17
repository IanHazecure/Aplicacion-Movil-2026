package com.example.nutriapp.data

import com.example.nutriapp.model.Receta

object RecetasRepository {
    val recetas: List<Receta> = listOf(
    Receta(
        id = 1,
        dia = "Lunes",
        nombre = "Ensalada de pollo y quinoa",
        descripcion = "Pechuga de pollo a la plancha con quinoa, tomate, " +
                "pepino y palta",
        calorias = 420,
        proteinasG = 35,
        carbohidratosG = 40,
        grasasG = 14,
        recomendacion = "Buena fuente de proteína."
    ),
    Receta(
        id = 2,
        dia = "Martes",
        nombre = "Lentejas guisadas con verduras",
        descripcion = "Lentejas cocidas con zanahoria, zapallo, cebolla y " +
                "comino, arroz integral.",
        calorias = 380,
        proteinasG = 18,
        carbohidratosG = 55,
        grasasG = 8,
        recomendacion = "Rica en fibra y hierro vegetal."
    ),
    Receta(
        id = 3,
        dia = "Miércoles",
        nombre = "Salmón al horno con vegetales",
        descripcion = "Filete de salmón horneado con brócoli, zapallitos " +
                "italianos y papas",
        calorias = 450,
        proteinasG = 32,
        carbohidratosG = 30,
        grasasG = 20,
        recomendacion = ""
    ),
    Receta(
        id = 4,
        dia = "Jueves",
        nombre = "Wrap integral de pavo",
        descripcion = "Tortilla integral rellena con pechuga de pavo, " +
                "lechuga, tomate y yogur natural como aderezo.",
        calorias = 350,
        proteinasG = 28,
        carbohidratosG = 35,
        grasasG = 10,
        recomendacion = ""
    ),
    Receta(
        id = 5,
        dia = "Viernes",
        nombre = "Tazón de garbanzos y verduras asadas",
        descripcion = "Garbanzos cocidos con pimentón, berenjena y " +
                "cebolla morada asados, con un toque de tahini.",
        calorias = 400,
        proteinasG = 16,
        carbohidratosG = 50,
        grasasG = 15,
        recomendacion = ""
    )
    )
}
