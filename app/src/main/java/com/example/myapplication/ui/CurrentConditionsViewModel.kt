package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import com.example.myapplication.models.CurrentCondition
import com.example.myapplication.models.LatitudeLongitude
import com.example.myapplication.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CurrentConditionsViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel() {
    private val _currentConditions = Channel<CurrentCondition>()

    public val currentConditions: Flow<CurrentCondition> = _currentConditions.receiveAsFlow()

    fun fetchData() = runBlocking {
        val currentConditions = api.getCurrentConditions("55106")
        _currentConditions.trySend(currentConditions)
    }

    fun fetchCurrentLocationData(latitudeLongitude: LatitudeLongitude) = runBlocking {
        val currentConditions = api.getCurrentConditions(latitudeLongitude.latitude, latitudeLongitude.longitude)
        _currentConditions.trySend(currentConditions)
    }

}