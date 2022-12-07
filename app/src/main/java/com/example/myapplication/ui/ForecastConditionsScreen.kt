package com.example.myapplication.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.DayForecast
import com.example.myapplication.ForecastTemp
import com.example.myapplication.R
import com.example.myapplication.forecastData
import com.example.myapplication.models.LatitudeLongitude

val startDay = 1665014340L
val sunrise = 1664953200L
val sunset = 1664996400L

val forecastData = (0 until 16).map {
    DayForecast(
        date = startDay + (it * (24 * 60 * 60)),
        sunrise = sunrise + (it * 24 * 60 * 60),
        sunset = sunset + (it * 24 * 60 * 60),
        temp = ForecastTemp(min = 70 + it, max = 80 + it),
        pressure = 1024f,
        humidity = 76,
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen(
    latitudeLongitude: LatitudeLongitude?,
    forecastViewModel: ForecastConditionsViewModel = hiltViewModel(),
){
    if (latitudeLongitude != null){
        LaunchedEffect(Unit){
            forecastViewModel.fetchForecast(latitudeLongitude)
        }
    }else{
        LaunchedEffect(Unit) {
            forecastViewModel.fetchData()
        }
    }
    LazyColumn{
        items(forecastData) { item: DayForecast ->
            ForecastConditionsScreen(item = item)
        }
    }
}

@Composable
private fun ForecastConditionsScreen(
    item: DayForecast,
){
    Row (
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically
            ){
        val textStyle = TextStyle(
            fontSize = 12.sp,
        )
        Image(painter = painterResource(id = R.drawable.sun_icon), contentDescription = "")
        Text(
            text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 12.sp,
            )
        )

        Spacer(modifier = Modifier.weight(.5f, fill = true))
        Column(
            horizontalAlignment = Alignment.End
        ){
            Text(text = stringResource(id = R.string.high_temp, item.temp.max))
            Text(text = stringResource(id = R.string.low_temp, item.temp.min))
        }
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(text = stringResource(id = R.string.label_sunrise, item.sunrise.toHourMinute()))
            Text(text = stringResource(id = R.string.label_sunset, item.sunset.toHourMinute()))
        }
    }
}

@Preview
@Composable
fun ForecastConditionsScreenPreview(){
    ForecastConditionsScreen(item = forecastData[0])
}
