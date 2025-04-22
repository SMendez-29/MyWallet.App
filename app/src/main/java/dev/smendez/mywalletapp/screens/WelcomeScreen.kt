package dev.smendez.mywalletapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.smendez.mywalletapp.Screens

@Composable
fun WelcomeScreen(navController: NavHostController) {
    // Reutilizamos el fondo con degradado como en el Splash
    val gradientColors = listOf(
        Color(0xFF0057B8), // Azul Francia
        Color(0xFF8A2BE2), // Lila fuerte
        Color(0xFFFFC107)  // Amarillo cálido
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(gradientColors)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido a MyWallet",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(30.dp))

            TextButton(
                onClick = { navController.navigate(Screens.LoginScreen.name) },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.White),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Iniciar Sesión",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            TextButton(
                onClick = { navController.navigate(Screens.RegisterScreen.name) },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.White),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Registrarse",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
