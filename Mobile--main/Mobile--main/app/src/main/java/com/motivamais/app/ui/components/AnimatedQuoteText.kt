package com.motivamais.app.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Componente que exibe a frase motivacional com animação de fade-in/fade-out
 */
@Composable
fun AnimatedQuoteText(
    quote: String,
    isVisible: Boolean,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(
            animationSpec = androidx.compose.animation.core.tween(durationMillis = 800)
        ),
        exit = fadeOut(
            animationSpec = androidx.compose.animation.core.tween(durationMillis = 400)
        ),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(
                text = quote,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 32.sp
                ),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

