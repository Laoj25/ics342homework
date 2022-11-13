package com.example.myapplication.models

import com.example.myapplication.ForecastTemp
import com.squareup.moshi.Json

data class Weather(
    @Json (name = "icon") val iconName: String,
)

data class ForecastConditionsData(
    @Json(name = "pressure") val pressure: Float,
    @Json(name = "humidity") val humidity: Float,
    @Json(name = "date") val date: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
    @Json(name = "forecastTemp") val forecastTemp: List<ForecastTemp>,

)

data class ForecastTemp(
    @Json(name = "minTemp")val minTemp: Float,
    @Json(name = "maxTemp")val maxTemp: Float,
)

data class ForecastConditions(
    @Json(name = "weather") val weatherData: List<Weather>,
    @Json(name = "main") val forecast: ForecastConditionsData,
)

