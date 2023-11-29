package com.example.nemuiin_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nemuiin_test.screen.FormHilang
import com.example.nemuiin_test.screen.FormTemuan
import com.example.nemuiin_test.screen.Home
import com.example.nemuiin_test.screen.Login
import com.example.nemuiin_test.screen.Register
import com.example.nemuiin_test.screen.ListBarangHilangContent
import com.example.nemuiin_test.screen.ListBarangTemuanContent
import com.example.nemuiin_test.ui.theme.Nemuiin_testTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "login") {
                composable("login") { Login(navController) }
                composable("register") { Register(navController) }
                composable("home") { Home(navController) }
                composable("formHilang") { FormHilang() }
                composable("formTemuan") { FormTemuan() }
            }
        }
    }
}
