package dev.smendez.mywalletapp.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Scaffold
import androidx.navigation.NavHostController
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import dev.smendez.mywalletapp.ui.theme.HomeTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { HomeTopBar() },
        bottomBar = { BottomNavBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 🔹 Fondo con degradado azul a blanco
            Canvas (modifier = Modifier.fillMaxSize()) {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0057B8), Color.White),
                    startY = 0f,
                    endY = size.height * 0.35f // El degradado ocupa el 35% de la pantalla
                )
                drawRect(brush = gradient, size = size)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // 🔹 Tarjeta de saldo sobre el degradado
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Saldo disponible", color = Color.Gray, fontSize = 14.sp)
                        Text(text = "$10,000", color = Color.Black, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))

                        // 🔹 Botones de acción
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ActionButton(text = "Ingresar", icon = Icons.Default.ArrowDownward)
                            ActionButton(text = "Transferir", icon = Icons.Default.ArrowUpward)
                            ActionButton(text = "Tu CBU", icon = Icons.Default.AccountBalance)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 🔹 Movimientos recientes
                Text(text = "Movimientos recientes", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                LazyColumn {
                    items(5) { index ->
                        TransactionItem("Compra en Tienda $index", "-$500", "01/04/2025")
                    }
                }
            }
        }
    }
}

// 🔹 **TopBar Azul con Menú**
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(
        title = { Text(text = "Hola, Sofía", color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0057B8)),
        actions = {
            IconButton(onClick = { /* Menú Opciones */ }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menú", tint = Color.White)
            }
        }
    )
}

// 🔹 **Bottom Navigation Bar**
@Composable
fun BottomNavBar() {
    NavigationBar {
        NavigationBarItem(icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") }, selected = true, onClick = {})
        NavigationBarItem(icon = { Icon(Icons.Default.History, contentDescription = "Movimientos") }, selected = false, onClick = {})
        NavigationBarItem(icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") }, selected = false, onClick = {})
    }
}

// 🔹 **Botón de Acción**
@Composable
fun ActionButton(text: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable { /* Acción */ }) {
        Icon(imageVector = icon, contentDescription = text, tint = Color(0xFF0057B8), modifier = Modifier.size(32.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, color = Color.Black, fontSize = 12.sp)
    }
}

// 🔹 **Ítem de Movimiento Reciente**
@Composable
fun TransactionItem(description: String, amount: String, date: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = description, fontWeight = FontWeight.Bold)
                Text(text = date, fontSize = 12.sp, color = Color.Gray)
            }
            Text(text = amount, fontWeight = FontWeight.Bold, color = Color.Red)
        }
    }
}