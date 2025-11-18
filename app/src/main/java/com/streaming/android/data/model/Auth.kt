package com.streaming.android.data.model

import java.util.Date

data class LoginRequest(
    val email: String,
    val senha: String
)

data class AuthResponse(
    val token: String,
    val email: String,
    val role: String,
    val expiraEm: Date
)


