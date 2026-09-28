package com.example.nutriapp.data

import com.example.nutriapp.model.UsuarioPerfil
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UsuarioFirestoreService {

    private val coleccion = FirebaseFirestore.getInstance().collection("usuarios")

    suspend fun crear(usuario: UsuarioPerfil): Result<Unit> {
        return try {
            coleccion.document(usuario.uid).set(usuario).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun obtener(uid: String): Result<UsuarioPerfil?> {
        return try {
            val documento = coleccion.document(uid).get().await()
            Result.success(documento.toObject(UsuarioPerfil::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun obtenerTodos(): Result<List<UsuarioPerfil>> {
        return try {
            val snapshot = coleccion.get().await()
            Result.success(snapshot.toObjects(UsuarioPerfil::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun actualizar(usuario: UsuarioPerfil): Result<Unit> {
        return try {
            coleccion.document(usuario.uid).set(usuario).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun eliminar(uid: String): Result<Unit> {
        return try {
            coleccion.document(uid).delete().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}