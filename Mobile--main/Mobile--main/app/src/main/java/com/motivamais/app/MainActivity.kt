package com.motivamais.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotivaMaisTheme {
                // Chama a tela principal do aplicativo
                MotivationScreen()
            }
        }
    }
}

/**
 * Tela principal do aplicativo que gerencia a UI e as interações com o ViewModel.
 */
@Composable
fun MotivationScreen(viewModel: MotivationViewModel = viewModel()) {
    // Observa os estados do ViewModel. A delegação 'by' extrai o valor do State.
    val currentQuote by viewModel.currentQuote
    val isVisible by viewModel.isVisible
    val gradientColors by viewModel.gradientColors

    // Este efeito é executado sempre que o valor de 'isVisible' muda.
    LaunchedEffect(isVisible) {
        // Se o conteúdo se tornou invisível (após o clique no botão)...
        if (!isVisible) {
            // ...aguarda a animação de fade-out terminar...
            delay(400)
            // ...e só então pede ao ViewModel para atualizar os dados (frase e cor).
            viewModel.updateQuoteAndGradient()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Gradiente animado no fundo.
        // CORREÇÃO: Passa os objetos Color diretamente, sem conversões.
        AnimatedGradientBackground(
            startColor = gradientColors[0],
            endColor = gradientColors[1],
            modifier = Modifier.fillMaxSize()
        )

        // Conteúdo principal da tela
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Componente para exibir a frase motivacional com animação.
            AnimatedQuoteText(
                quote = currentQuote,
                isVisible = isVisible,
                modifier = Modifier.weight(1f) // Ocupa o espaço disponível
            )

            // Botão para solicitar uma nova frase.
            AnimatedButton(
                text = "Nova Frase",
                onClick = {
                    // Chama a função no ViewModel para iniciar o processo de atualização.
                    viewModel.getNewQuote()
                }
            )
        }
    }
}
