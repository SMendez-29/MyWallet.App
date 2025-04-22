package dev.smendez.mywalletapp.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(0.8f) }

    LaunchedEffect(true) {
        alpha.animateTo(1f, animationSpec = tween(1000))
        scale.animateTo(1f, animationSpec = tween(1000))

        delay(2000)
        onTimeout()
    }

    val gradientColors = listOf(
        Color(0xFF0057B8), // Azul Francia
        Color(0xFF8A2BE2), // Lila fuerte
        Color(0xFFFFC107)  // Amarillo cálido
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(colors = gradientColors)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "My Wallet",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .alpha(alpha.value)
                .scale(scale.value)
        )
    }
}