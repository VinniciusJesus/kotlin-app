package com.streaming.android.data.model

data class Criador(
    val id: Int,
    val usuarioId: Int,
    val bio: String,
    val canalNome: String,
    val usuario: Usuario? = null
)

data class Usuario(
    val id: Int,
    val nome: String,
    val email: String
)


