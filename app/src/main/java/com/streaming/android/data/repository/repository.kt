package com.streaming.android.data.repository

import com.streaming.android.data.model.AuthRequest
import com.streaming.android.data.model.AuthResponse
import com.streaming.android.data.model.Conteudo
import com.streaming.android.data.model.Playlist
import com.streaming.android.data.remote.StreamingApiService

class StreamingRepository(
    private val api: StreamingApiService
) {

    suspend fun getConteudos(): List<Conteudo> {
        return api.getConteudos()
    }

    suspend fun getConteudo(id: Int): Conteudo? {
        return runCatching { api.getConteudo(id) }.getOrNull()
    }

    suspend fun getPlaylists(): List<Playlist> {
        return api.getPlaylists()
    }

    suspend fun getPlaylist(id: Int): Playlist? {
        return runCatching { api.getPlaylist(id) }.getOrNull()
    }

    suspend fun login(email: String, senha: String): AuthResponse? {
        val request = AuthRequest(email = email, senha = senha)
        return runCatching { api.login(request) }.getOrNull()
    }
}
