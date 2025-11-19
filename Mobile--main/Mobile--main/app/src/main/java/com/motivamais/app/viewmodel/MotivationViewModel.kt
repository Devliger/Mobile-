package com.motivamais.app.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * ViewModel para a tela de motivação.
 * Gerencia o estado da UI, incluindo a frase atual, as cores do gradiente e as animações.
 */
class MotivationViewModel : ViewModel() {

    // Lista de frases motivacionais
    private val quotes = listOf(
        "Acredite em si mesmo e tudo será possível.",
        "O sucesso é a soma de pequenos esforços repetidos dia após dia.",
        "A persistência realiza o impossível.",
        "O único lugar onde o sucesso vem antes do trabalho é no dicionário.",
        "Sua única limitação é você mesmo."
    )

    // Lista de pares de cores para o gradiente
    private val gradients = listOf(
        listOf(Color(0xFF8E2DE2), Color(0xFF4A00E0)),
        listOf(Color(0xFF11998e), Color(0xFF38ef7d)),
        listOf(Color(0xFFff9966), Color(0xFFff5e62)),
        listOf(Color(0xFF00c6ff), Color(0xFF0072ff))
    )

    // --- Estados observáveis pela UI ---

    // Estado para a frase atual
    private val _currentQuote = mutableStateOf(quotes.first())
    val currentQuote: State<String> = _currentQuote

    // Estado para as cores do gradiente
    private val _gradientColors = mutableStateOf(gradients.first())
    val gradientColors: State<List<Color>> = _gradientColors

    // Estado para controlar a visibilidade e animação de fade
    private val _isVisible = mutableStateOf(true)
    val isVisible: State<Boolean> = _isVisible

    /**
     * Inicia o processo para obter uma nova frase.
     * Primeiro, aciona a animação de fade-out (invisível).
     * O LaunchedEffect na UI detectará essa mudança e chamará updateQuoteAndGradient.
     */
    fun getNewQuote() {
        viewModelScope.launch {
            _isVisible.value = false
        }
    }

    /**
     * Atualiza a frase e as cores do gradiente, e então aciona a animação de fade-in.
     * Esta função é chamada após o término da animação de fade-out.
     */
    fun updateQuoteAndGradient() {
        // Seleciona uma nova frase aleatória diferente da atual
        var newQuote = quotes.random()
        while (newQuote == _currentQuote.value) {
            newQuote = quotes.random()
        }
        _currentQuote.value = newQuote

        // Seleciona um novo gradiente aleatório diferente do atual
        var newGradient = gradients.random()
        while (newGradient == _gradientColors.value) {
            newGradient = gradients.random()
        }
        _gradientColors.value = newGradient

        // Torna o texto visível novamente para acionar o fade-in
        _isVisible.value = true
    }
}
