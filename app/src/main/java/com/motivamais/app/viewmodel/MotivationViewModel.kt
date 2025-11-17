package com.motivamais.app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.motivamais.app.data.MotivationalQuotes
import kotlin.random.Random

/**
 * ViewModel que gerencia o estado das frases motivacionais
 * Responsável por selecionar frases aleatórias e gerenciar o estado da UI
 */
class MotivationViewModel : ViewModel() {
    
    // Estado atual da frase exibida
    var currentQuote by mutableStateOf(getRandomQuote())
        private set
    
    // Estado para controlar a animação de fade
    var isVisible by mutableStateOf(true)
        private set
    
    // Cores do gradiente atual
    var gradientColors by mutableStateOf(generateRandomGradient())
        private set
    
    /**
     * Obtém uma frase aleatória da lista
     */
    private fun getRandomQuote(): String {
        val quotes = MotivationalQuotes.quotes
        return quotes[Random.nextInt(quotes.size)]
    }
    
    /**
     * Gera um par de cores aleatórias para o gradiente
     * Retorna uma lista de 2 cores em formato Long (ARGB)
     */
    private fun generateRandomGradient(): List<Long> {
        val colorPairs = listOf(
            // Gradientes suaves e bonitos
            listOf(0xFF667EEA, 0xFF764BA2), // Roxo para roxo escuro
            listOf(0xFFF093FB, 0xFFF5576C), // Rosa para vermelho
            listOf(0xFF4FACFE, 0xFF00F2FE), // Azul claro para azul
            listOf(0xFF43E97B, 0xFF38F9D7), // Verde para turquesa
            listOf(0xFFFA709A, 0xFFFEE140), // Rosa para amarelo
            listOf(0xFF30CFD0, 0xFF330867), // Turquesa para roxo escuro
            listOf(0xFFA8EDEA, 0xFFFED6E3), // Azul claro para rosa
            listOf(0xFFD299C2, 0xFFFEF9D7), // Roxo claro para amarelo claro
            listOf(0xFF89F7FE, 0xFF66A6FF), // Azul claro para azul
            listOf(0xFFFD746C, 0xFF2C3E50), // Laranja para cinza escuro
            listOf(0xFFF6D365, 0xFFFDA085), // Amarelo para laranja
            listOf(0xFF84FAB0, 0xFF8FD3F4), // Verde para azul claro
            listOf(0xFFA1C4FD, 0xFFC2E9FB), // Azul para azul muito claro
            listOf(0xFFFF9A9E, 0xFFFECFEF), // Rosa para rosa claro
            listOf(0xFFFFECD2, 0xFFFCB69F), // Bege para pêssego
            listOf(0xFFFF8A80, 0xFFEA4C89), // Vermelho para rosa
            listOf(0xFF667EEA, 0xFF764BA2), // Roxo para roxo escuro
            listOf(0xFFF093FB, 0xFFF5576C), // Rosa para vermelho
            listOf(0xFF4FACFE, 0xFF00F2FE), // Azul claro para azul
            listOf(0xFF43E97B, 0xFF38F9D7)  // Verde para turquesa
        )
        return colorPairs[Random.nextInt(colorPairs.size)]
    }
    
    /**
     * Atualiza para uma nova frase motivacional
     * Dispara a animação de fade-out, depois fade-in com nova frase
     */
    fun getNewQuote() {
        // Fade-out da frase atual
        isVisible = false
        
        // Após um breve delay, atualiza a frase e o gradiente
        // (O delay será gerenciado pela UI através das animações)
    }
    
    /**
     * Atualiza a frase e o gradiente após o fade-out
     * Chamado pela UI quando a animação de fade-out termina
     */
    fun updateQuoteAndGradient() {
        currentQuote = getRandomQuote()
        gradientColors = generateRandomGradient()
        isVisible = true
    }
}

