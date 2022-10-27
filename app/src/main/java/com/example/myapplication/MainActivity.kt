package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import com.example.myapplication.ui.CurrentConditionsScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAB, "onCreate() called")

        setContent {
            CurrentConditionsScreen(
                cityName = stringResource(id = R.string.city_name),
                temperature = stringResource(id = R.string.current_temp, 56)
            )

        }

    }

    companion object {
        private const val TAB = "MainActivity"
    }
}