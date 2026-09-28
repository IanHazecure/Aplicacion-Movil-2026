package com.example.nutriapp.data

import com.example.nutriapp.model.Receta
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RecetaFirestoreService {

    private val coleccion = FirebaseFirestore.getInstance().collection("recetas")

    suspend fun crear(receta: Receta): Result<String> {
        return try {
            val referencia = coleccion.document()
            referencia.set(receta.copy(id = referencia.id)).await()
            Result.success(referencia.id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun obtenerTodas(): Result<List<Receta>> {
        return try {
            val snapshot = coleccion.get().await()
            Result.success(snapshot.toObjects(Receta::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun obtenerPorId(id: String): Result<Receta?> {
        return try {
            val documento = coleccion.document(id).get().await()
            Result.success(documento.toObject(Receta::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun actualizar(receta: Receta): Result<Unit> {
        return try {
            coleccion.document(receta.id).set(receta).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun eliminar(id: String): Result<Unit> {
        return try {
            coleccion.document(id).delete().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}