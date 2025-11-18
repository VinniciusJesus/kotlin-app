package com.streaming.android.data.model

import java.util.Date

data class Conteudo(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val urlMidia: String,
    val duracaoSeg: Int,
    val criadorId: Int,
    val dataPublicacao: Date,
    val isAtivo: Boolean,
    val criador: Criador? = null
)


