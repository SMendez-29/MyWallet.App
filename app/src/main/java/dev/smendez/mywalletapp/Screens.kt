package dev.smendez.mywalletapp

import android.health.connect.datatypes.ExerciseRoute

sealed class Screens(val name : String) {
    object SplashScreen : Screens ("splash")
    object WelcomeScreen : Screens ("welcome")
    object LoginScreen : Screens ("login")
    object RegisterScreen : Screens ("register")
    object HomeScreen : Screens ("home")
    object ProfileScreen : Screens("profile")
    object SettingsScreen : Screens("settings")
    object SecurityScreen : Screens("security")
    object HelpCenterScreen : Screens("help_center")
}