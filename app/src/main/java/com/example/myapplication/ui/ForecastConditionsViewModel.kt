package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import com.example.myapplication.models.ForecastConditions
import com.example.myapplication.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ForecastConditionsViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel(){
    private val _forecastConditions = Channel<ForecastConditions>()

    public val forecastConditions: Flow<ForecastConditions> = _forecastConditions.receiveAsFlow()

    fun fetchData1() = runBlocking {
        val forecastConditions = api.getForecastConditions("55106")

        _forecastConditions.trySend(forecastConditions)
    }
}