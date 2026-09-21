package com.example.nutriapp.data

import android.content.Context
import androidx.core.content.edit

class PreferenciasUsuario(context: Context) {

    private val preferencias = context.getSharedPreferences("nutriapp_prefs", Context.MODE_PRIVATE)

    fun guardarCorreo(correo: String) {
        preferencias.edit { putString(KEY_CORREO, correo) }
    }

    fun obtenerCorreo(): String? = preferencias.getString(KEY_CORREO, null)

    fun borrarCorreo() {
        preferencias.edit { remove(KEY_CORREO) }
    }

    companion object {
        private const val KEY_CORREO = "correo_recordado"
    }
}