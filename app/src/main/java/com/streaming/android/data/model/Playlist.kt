package com.streaming.android.data.model

import java.util.Date

data class Playlist(
    val id: Int,
    val titulo: String,
    val descricao: String?,
    val dataCriacao: Date,
    val isPublica: Boolean,
    val usuarioId: Int,
    val itens: List<ItemPlaylist> = emptyList()
)

data class ItemPlaylist(
    val playlistId: Int,
    val conteudoId: Int,
    val ordem: Int,
    val conteudo: Conteudo? = null
)


