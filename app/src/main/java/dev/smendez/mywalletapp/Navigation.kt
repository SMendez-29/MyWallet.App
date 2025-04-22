package dev.smendez.mywalletapp

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.animateDecay
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.smendez.mywalletapp.screens.HomeScreen
import dev.smendez.mywalletapp.screens.LoginScreen
import dev.smendez.mywalletapp.screens.RegisterScreen
import dev.smendez.mywalletapp.screens.SplashScreen
import dev.smendez.mywalletapp.screens.WelcomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash",

        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }
    ) {
        composable("splash") {
            SplashScreen(
                onTimeout = {
                    navController.navigate("welcome") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }

        composable(Screens.WelcomeScreen.name) { WelcomeScreen(navController) }
        composable(Screens.LoginScreen.name) { LoginScreen(navController) }
        composable(Screens.RegisterScreen.name) { RegisterScreen(navController) }
        composable(Screens.HomeScreen.name) { HomeScreen(navController) }


    }
}