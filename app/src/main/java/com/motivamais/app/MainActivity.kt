package com.motivamais.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.motivamais.app.ui.components.AnimatedButton
import com.motivamais.app.ui.components.AnimatedGradientBackground
import com.motivamais.app.ui.components.AnimatedQuoteText
import com.motivamais.app.ui.theme.MotivaMaisTheme
import com.motivamais.app.viewmodel.MotivationViewModel
import kotlinx.coroutines.delay

/**
 * Activity principal do aplicativo MotivaMais
 * Exibe frases motivacionais com animações suaves e gradiente animado
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotivaMaisTheme {
                MotivationScreen()
            }
        }
    }
}

/**
 * Tela principal do aplicativo
 * Gerencia a UI e as interações com o ViewModel
 */
@Composable
fun MotivationScreen(
    viewModel: MotivationViewModel = viewModel()
) {
    // Observa o estado do ViewModel
    val currentQuote by viewModel.currentQuote
    val isVisible by viewModel.isVisible
    val gradientColors by viewModel.gradientColors
    
    // Controla a animação de fade-out/fade-in
    LaunchedEffect(isVisible) {
        if (!isVisible) {
            // Aguarda o fade-out completar antes de atualizar
            delay(400)
            viewModel.updateQuoteAndGradient()
        }
    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        // Gradiente animado no fundo
        AnimatedGradientBackground(
            startColor = gradientColors[0],
            endColor = gradientColors[1],
            modifier = Modifier.fillMaxSize()
        )
        
        // Conteúdo principal
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Frase motivacional animada
            AnimatedQuoteText(
                quote = currentQuote,
                isVisible = isVisible,
                modifier = Modifier.weight(1f)
            )
            
            // Botão para nova frase
            AnimatedButton(
                text = "Nova Frase",
                onClick = {
                    viewModel.getNewQuote()
                }
            )
        }
    }
}

