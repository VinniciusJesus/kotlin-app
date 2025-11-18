# Streaming Android App (Kotlin)

Aplicativo Android moderno para assistir streamings, desenvolvido em Kotlin com Material Design 3.

## 📱 Características

- ✅ Interface moderna com Material Design 3
- ✅ Feed de conteúdos com RecyclerView
- ✅ Player de vídeo com ExoPlayer
- ✅ Sistema de Playlists
- ✅ Dados mockados baseados na API
- ✅ Arquitetura limpa e organizada

## 🏗️ Estrutura do Projeto

```
streaming-android-kotlin/
├── app/
│   ├── src/main/
│   │   ├── java/com/streaming/android/
│   │   │   ├── data/
│   │   │   │   ├── model/          # Models Kotlin
│   │   │   │   └── repository/     # Repository com dados mockados
│   │   │   └── ui/
│   │   │       ├── adapter/        # Adapters para RecyclerView
│   │   │       ├── feed/           # Fragment de Feed
│   │   │       ├── playlists/      # Fragment de Playlists
│   │   │       ├── player/         # Activity do Player
│   │   │       └── playlistdetail/  # Detalhes da Playlist
│   │   └── res/                    # Recursos (layouts, valores)
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

## 🚀 Como Executar

1. Abra o Android Studio
2. Selecione "Open an Existing Project"
3. Navegue até a pasta `streaming-android-kotlin`
4. Aguarde o Gradle sincronizar
5. Execute no emulador ou dispositivo físico

## 📦 Dependências Principais

- **Material Design 3** - UI moderna
- **ExoPlayer** - Player de vídeo
- **Retrofit** - Cliente HTTP (estrutura)
- **Glide** - Carregamento de imagens
- **Coroutines** - Programação assíncrona
- **ViewBinding** - Binding de views

## 🎨 Funcionalidades

### Feed de Conteúdos
- Lista todos os conteúdos disponíveis
- Cards modernos com thumbnails
- Informações do criador
- Duração dos vídeos

### Player de Vídeo
- Player fullscreen com ExoPlayer
- Controles de reprodução
- Suporte a landscape

### Playlists
- Visualizar playlists criadas
- Detalhes da playlist
- Lista de vídeos na playlist

## 📝 Dados Mockados

Os dados são mockados no `MockRepository` e incluem:
- 8 conteúdos de exemplo
- 3 playlists de exemplo
- Informações de criadores

## 🔧 Configuração

- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Kotlin**: 1.9.0
- **Gradle**: 8.0

## 📄 Licença

Projeto desenvolvido para fins acadêmicos.


