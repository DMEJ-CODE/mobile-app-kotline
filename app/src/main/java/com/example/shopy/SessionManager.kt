package com.example.shopy

import android.content.Context
import android.content.SharedPreferences


class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE)

    fun saveLogin(name: String, email: String = "") {
        prefs.edit().apply {
            putBoolean("logged", true)
            putString("name", name)
            putString("email", email)

            apply()
        }
    }

    fun isLogged(): Boolean = prefs.getBoolean("logged", false)
    fun getName(): String? = prefs.getString("name", null)
    fun getEmail(): String? = prefs.getString("email", null)

    fun logout() {
        prefs.edit().clear().apply()
    }
}