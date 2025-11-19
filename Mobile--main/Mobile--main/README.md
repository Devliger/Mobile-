# MotivaMais

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose que exibe frases motivacionais com animações suaves e gradientes animados.

## Características

- ✨ **Tema Material 3** com suporte automático a dark/light mode
- 🎨 **Gradiente animado** no fundo que muda suavemente a cada nova frase
- 💫 **Animações suaves** de fade-in/fade-out para as frases
- 🎯 **Botão animado** com efeito de scale ao clicar
- 📚 **40+ frases motivacionais** variadas
- 🏗️ **Arquitetura limpa** com ViewModel e componentes Compose

## Estrutura do Projeto

```
app/src/main/java/com/motivamais/app/
├── MainActivity.kt              # Activity principal
├── data/
│   └── MotivationalQuotes.kt   # Lista de frases motivacionais
├── viewmodel/
│   └── MotivationViewModel.kt  # ViewModel para gerenciar estado
├── ui/
│   ├── theme/                  # Tema Material 3
│   │   ├── Color.kt
│   │   ├── Theme.kt
│   │   └── Type.kt
│   └── components/             # Componentes Compose
│       ├── AnimatedButton.kt
│       ├── AnimatedGradientBackground.kt
│       └── AnimatedQuoteText.kt
```

## Requisitos

- Android Studio Hedgehog ou superior
- Min SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)
- Kotlin 1.9.10+
- Jetpack Compose

## Como Usar

1. Abra o projeto no Android Studio
2. Sincronize o Gradle
3. Execute o aplicativo em um dispositivo ou emulador
4. Toque no botão "Nova Frase" para ver uma nova frase motivacional com animações

## Tecnologias Utilizadas

- **Kotlin** - Linguagem de programação
- **Jetpack Compose** - Framework de UI declarativa
- **Material 3** - Design system
- **ViewModel** - Gerenciamento de estado
- **Coroutines** - Programação assíncrona

## Licença

Este projeto é de código aberto e está disponível para uso livre.

