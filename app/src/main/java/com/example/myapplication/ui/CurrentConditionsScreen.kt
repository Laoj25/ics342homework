package com.example.myapplication.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.R.string
import com.example.myapplication.models.CurrentCondition
import com.example.myapplication.models.LatitudeLongitude


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    latitudeLongitude: LatitudeLongitude?,
    viewModel: CurrentConditionsViewModel = hiltViewModel(),
    onGetWeatherForMyLocationClick: () -> Unit,
    onForecastButtonClick: () -> Unit,
){
    
    val state by viewModel.currentConditions.collectAsState(null)

    if (latitudeLongitude != null){
        LaunchedEffect(Unit) {
            viewModel.fetchCurrentLocationData(latitudeLongitude)
        }
    } else {
        LaunchedEffect(Unit) {
            viewModel.fetchData()
        }
    }

    Scaffold(
        topBar = { AppBar(title = stringResource(id = string.app_name )) },
    ){
        state?.let {
            CurrentConditionsScreen(it, onGetWeatherForMyLocationClick, onForecastButtonClick)
        }
    }
}

@Composable
private fun CurrentConditionsScreen(
    currentCondition: CurrentCondition,
    onGetWeatherForMyLocationClick: () -> Unit,
    onForecastButtonClick: () -> Unit,

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = currentCondition.cityName,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
            )
        )


        Row(
            modifier = Modifier
                .padding(horizontal = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) 
        {

            Text(
                text = stringResource(id = R.string.current_temp, currentCondition.conditions.temperature.toInt()),
                style = TextStyle(
                    fontSize = 72.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Start
                )

            )
            

            Spacer(modifier = Modifier.weight(1.0f, true))
            val iconUrl = String.format("https://openweathermap.org/img/wn/%s@2x.png", currentCondition.weatherData.firstOrNull()?.iconName)
            AsyncImage(
                model = iconUrl,
                modifier = Modifier
                    .size(72.dp),
                contentDescription = "Sunny",
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = stringResource(id = R.string.Feels_like, currentCondition.conditions.feelsLike.toInt()), Modifier.padding(horizontal = 35.dp))
            Text(text = stringResource(id = R.string.low_temp, currentCondition.conditions.minTemperature.toInt()),)
            Text(text = stringResource(id = R.string.high_temp, currentCondition.conditions.maxTemperature.toInt()),)
            Text(text = stringResource(id = R.string.humidity, currentCondition.conditions.humidity.toInt()),)
            Text(text = stringResource(id = R.string.pressure, currentCondition.conditions.pressure.toInt()),)
        }
        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onForecastButtonClick) {
            Text(text = stringResource(id = R.string.forecast))
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onGetWeatherForMyLocationClick) {
            Text(text = stringResource(id = string.get_weather_for_my_location))
        }
    }
}
@Preview(
    showSystemUi = true,
)
@Composable
fun CurrentConditionsScreenPreview (){

}
