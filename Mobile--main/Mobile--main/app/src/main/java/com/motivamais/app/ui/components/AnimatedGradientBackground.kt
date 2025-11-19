package com.motivamais.app.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Componente que exibe um gradiente animado no fundo
 * As cores mudam suavemente quando o gradiente é atualizado
 */
@Composable
fun AnimatedGradientBackground(
    startColor: Color,
    endColor: Color,
    modifier: Modifier = Modifier
) {
    // Anima a transição entre cores
    val animatedStartColor by animateColorAsState(
        targetValue = startColor, // CORREÇÃO: Passe a variável diretamente
        animationSpec = tween(durationMillis = 1000),
        label = "startColor"
    )

    val animatedEndColor by animateColorAsState(
        targetValue = endColor, // CORREÇÃO: Passe a variável diretamente
        animationSpec = tween(durationMillis = 1000),
        label = "endColor"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(animatedStartColor, animatedEndColor)
                )
            )
    )
}
