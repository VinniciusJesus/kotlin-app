package com.streaming.android.data.repository

import com.streaming.android.data.model.*
import java.util.*

class MockRepository {
    
    private val mockConteudos = listOf(
        Conteudo(
            id = 1,
            titulo = "Tutorial de Kotlin - Parte 1",
            descricao = "Aprenda os fundamentos do Kotlin e comece sua jornada no desenvolvimento Android",
            urlMidia = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            duracaoSeg = 3600,
            criadorId = 1,
            dataPublicacao = Date(),
            isAtivo = true,
            criador = Criador(
                id = 1,
                usuarioId = 1,
                bio = "Canal dedicado ao ensino de programação e desenvolvimento mobile",
                canalNome = "Tech Channel",
                usuario = Usuario(id = 1, nome = "João Silva", email = "joao@email.com")
            )
        ),
        Conteudo(
            id = 2,
            titulo = "Android Development Basics",
            descricao = "Introdução completa ao desenvolvimento Android com Kotlin",
            urlMidia = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            duracaoSeg = 2400,
            criadorId = 1,
            dataPublicacao = Date(),
            isAtivo = true,
            criador = Criador(
                id = 1,
                usuarioId = 1,
                bio = "Canal dedicado ao ensino de programação e desenvolvimento mobile",
                canalNome = "Tech Channel",
                usuario = Usuario(id = 1, nome = "João Silva", email = "joao@email.com")
            )
        ),
        Conteudo(
            id = 3,
            titulo = "Material Design 3",
            descricao = "Criando interfaces modernas e bonitas com Material Design 3",
            urlMidia = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            duracaoSeg = 1800,
            criadorId = 2,
            dataPublicacao = Date(),
            isAtivo = true,
            criador = Criador(
                id = 2,
                usuarioId = 2,
                bio = "Especialista em design de interfaces e experiência do usuário",
                canalNome = "Design Pro",
                usuario = Usuario(id = 2, nome = "Maria Santos", email = "maria@email.com")
            )
        ),
        Conteudo(
            id = 4,
            titulo = "Jetpack Compose Tutorial",
            descricao = "UI declarativa para Android - O futuro do desenvolvimento",
            urlMidia = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
            duracaoSeg = 4200,
            criadorId = 1,
            dataPublicacao = Date(),
            isAtivo = true,
            criador = Criador(
                id = 1,
                usuarioId = 1,
                bio = "Canal dedicado ao ensino de programação e desenvolvimento mobile",
                canalNome = "Tech Channel",
                usuario = Usuario(id = 1, nome = "João Silva", email = "joao@email.com")
            )
        ),
        Conteudo(
            id = 5,
            titulo = "API REST com Retrofit",
            descricao = "Aprenda a consumir APIs REST no Android usando Retrofit",
            urlMidia = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
            duracaoSeg = 3000,
            criadorId = 1,
            dataPublicacao = Date(),
            isAtivo = true,
            criador = Criador(
                id = 1,
                usuarioId = 1,
                bio = "Canal dedicado ao ensino de programação e desenvolvimento mobile",
                canalNome = "Tech Channel",
                usuario = Usuario(id = 1, nome = "João Silva", email = "joao@email.com")
            )
        ),
        Conteudo(
            id = 6,
            titulo = "MVVM Architecture Pattern",
            descricao = "Padrão de arquitetura MVVM para aplicativos Android escaláveis",
            urlMidia = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
            duracaoSeg = 2700,
            criadorId = 1,
            dataPublicacao = Date(),
            isAtivo = true,
            criador = Criador(
                id = 1,
                usuarioId = 1,
                bio = "Canal dedicado ao ensino de programação e desenvolvimento mobile",
                canalNome = "Tech Channel",
                usuario = Usuario(id = 1, nome = "João Silva", email = "joao@email.com")
            )
        ),
        Conteudo(
            id = 7,
            titulo = "Room Database Tutorial",
            descricao = "Persistência de dados local com Room Database",
            urlMidia = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
            duracaoSeg = 3300,
            criadorId = 1,
            dataPublicacao = Date(),
            isAtivo = true,
            criador = Criador(
                id = 1,
                usuarioId = 1,
                bio = "Canal dedicado ao ensino de programação e desenvolvimento mobile",
                canalNome = "Tech Channel",
                usuario = Usuario(id = 1, nome = "João Silva", email = "joao@email.com")
            )
        ),
        Conteudo(
            id = 8,
            titulo = "UI/UX Design Principles",
            descricao = "Princípios fundamentais de design de interfaces",
            urlMidia = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
            duracaoSeg = 2100,
            criadorId = 2,
            dataPublicacao = Date(),
            isAtivo = true,
            criador = Criador(
                id = 2,
                usuarioId = 2,
                bio = "Especialista em design de interfaces e experiência do usuário",
                canalNome = "Design Pro",
                usuario = Usuario(id = 2, nome = "Maria Santos", email = "maria@email.com")
            )
        )
    )
    
    private val mockPlaylists = listOf(
        Playlist(
            id = 1,
            titulo = "Meus Favoritos",
            descricao = "Vídeos que gosto de assistir",
            dataCriacao = Date(),
            isPublica = false,
            usuarioId = 1,
            itens = listOf(
                ItemPlaylist(1, 1, 1, mockConteudos[0]),
                ItemPlaylist(1, 2, 2, mockConteudos[1]),
                ItemPlaylist(1, 5, 3, mockConteudos[4])
            )
        ),
        Playlist(
            id = 2,
            titulo = "Tutoriais Android",
            descricao = "Aprenda desenvolvimento Android do zero",
            dataCriacao = Date(),
            isPublica = true,
            usuarioId = 1,
            itens = listOf(
                ItemPlaylist(2, 2, 1, mockConteudos[1]),
                ItemPlaylist(2, 4, 2, mockConteudos[3]),
                ItemPlaylist(2, 6, 3, mockConteudos[5]),
                ItemPlaylist(2, 7, 4, mockConteudos[6])
            )
        ),
        Playlist(
            id = 3,
            titulo = "Design e UI/UX",
            descricao = "Conteúdos sobre design",
            dataCriacao = Date(),
            isPublica = true,
            usuarioId = 1,
            itens = listOf(
                ItemPlaylist(3, 3, 1, mockConteudos[2]),
                ItemPlaylist(3, 8, 2, mockConteudos[7])
            )
        )
    )
    
    suspend fun getConteudos(): List<Conteudo> {
        return mockConteudos
    }
    
    suspend fun getConteudo(id: Int): Conteudo? {
        return mockConteudos.find { it.id == id }
    }
    
    suspend fun getPlaylists(): List<Playlist> {
        return mockPlaylists
    }
    
    suspend fun getPlaylist(id: Int): Playlist? {
        return mockPlaylists.find { it.id == id }
    }
    
    suspend fun login(email: String, senha: String): AuthResponse? {
        // Mock login - sempre retorna sucesso
        return AuthResponse(
            token = "mock_token_${System.currentTimeMillis()}",
            email = email,
            role = "User",
            expiraEm = Date(System.currentTimeMillis() + 86400000) // 24 horas
        )
    }
}


