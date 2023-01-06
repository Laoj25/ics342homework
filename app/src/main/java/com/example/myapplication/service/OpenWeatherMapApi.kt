package com.example.myapplication.service

import com.example.myapplication.models.CurrentCondition
import com.example.myapplication.models.ForecastConditions
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "61e80a81c053d9a475382b912d5f20d9",
        @Query("units") units: String = "imperial",
    ) : CurrentCondition

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "61e80a81c053d9a475382b912d5f20d9",
        @Query("units") units: String = "imperial",
    ) : CurrentCondition

    @GET("data/2.5/forecast/daily")
    suspend fun getForecastConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "61e80a81c053d9a475382b912d5f20d9",
        @Query("cnt") countDays: Int = 16,
        @Query("units") units: String = "imperial",
    ) : ForecastConditions

    @GET("data/2.5/weather")
    suspend fun getForecastConditions(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "61e80a81c053d9a475382b912d5f20d9",
        @Query("units") units: String = "imperial",
    ) : ForecastConditions
}