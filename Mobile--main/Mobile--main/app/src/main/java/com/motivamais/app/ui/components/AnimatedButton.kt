package com.motivamais.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Botão animado com efeito de scale ao clicar
 * Possui bordas arredondadas e sombra sutil
 */
@Composable
fun AnimatedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isPressed by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    
    // Animação de scale quando pressionado
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = tween(durationMillis = 100),
        label = "buttonScale"
    )
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                isPressed = true
                onClick()
                // Reset após um breve delay para permitir a animação
                coroutineScope.launch {
                    delay(150)
                    isPressed = false
                }
            },
            modifier = Modifier
                .scale(scale)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp
            )
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
    }
}

