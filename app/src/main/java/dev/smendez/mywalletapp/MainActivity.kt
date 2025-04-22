package dev.smendez.mywalletapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import dev.smendez.mywalletapp.screens.HomeScreen
import dev.smendez.mywalletapp.screens.WelcomeScreen


class MainActivity : ComponentActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {

                AppNavigation()
                }
            }
        }


