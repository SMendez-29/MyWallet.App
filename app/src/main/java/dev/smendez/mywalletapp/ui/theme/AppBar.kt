package dev.smendez.mywalletapp.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class) // Ese error ocurre porque TopAppBar y Scaffold de Material
// 3 aún están marcados como experimentales en Jetpack Compose.
// Para solucionarlo, necesitas agregar la anotación

// 🔹 AppBar simple con botón de volver
@Composable
fun SimpleTopAppBar(title: String = "", navController: NavController) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF0057B8), // Azul fuerte
            navigationIconContentColor = Color.White
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class) // Ese error ocurre porque TopAppBar y Scaffold de Material
// 3 aún están marcados como experimentales en Jetpack Compose.
// Para solucionarlo, necesitas agregar la anotación

// 🔹 AppBar con menú desplegable
@Composable
fun HomeTopAppBar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = { Text("Inicio", fontWeight = FontWeight.Bold) },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menú")
            }
        }
    )
}

