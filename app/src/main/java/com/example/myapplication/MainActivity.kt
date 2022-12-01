package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.CurrentConditions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAB, "onCreate() called")

        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "CurrentCondition"){
                composable("CurrentCondition"){
                    CurrentConditions(){
                        navController.navigate("Forecast")
                    }
                }
            }
        }

    }

    companion object {
        private const val TAB = "MainActivity"
    }
}