package com.example.nutriapp.data

import com.example.nutriapp.model.Minuta
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class MinutaFirestoreService {

    private val coleccion = FirebaseFirestore.getInstance().collection("minutas")

    suspend fun crear(minuta: Minuta): Result<String> {
        return try {
            val referencia = coleccion.document()
            referencia.set(minuta.copy(id = referencia.id)).await()
            Result.success(referencia.id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun obtenerTodas(): Result<List<Minuta>> {
        return try {
            val snapshot = coleccion.get().await()
            Result.success(snapshot.toObjects(Minuta::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun actualizar(minuta: Minuta): Result<Unit> {
        return try {
            coleccion.document(minuta.id).set(minuta).await()
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