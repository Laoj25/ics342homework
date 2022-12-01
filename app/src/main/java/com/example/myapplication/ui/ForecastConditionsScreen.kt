package com.example.myapplication.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.models.CurrentCondition
import com.example.myapplication.models.ForecastConditions

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastConditions(
    viewModel: ForecastConditionsViewModel = hiltViewModel(),
    onBackButtonClick: () -> Unit,
){

    val state by viewModel.forecastConditions.collectAsState(null)

    LaunchedEffect(Unit){
        viewModel.fetchData1()
    }
    Scaffold(topBar = { AppBar(title = R.string.app_name.toString()) }){

        state?.let {
            ForecastConditionsScreen(it){
                onBackButtonClick()
            }
        }
    }
}


@Composable
fun ForecastConditionsScreen(
    forecastConditions: ForecastConditions,
    onBackButtonClick: () -> Unit,
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = stringResource(id = R.string.forecast),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )

        )

        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(id = R.drawable.sun_icon),
                contentDescription = "Sunny",
            )
            Column(
                //modifier = Modifier.padding(horizontal = 11.dp),
                horizontalAlignment = Alignment.Start,
            ){
                Text(text = stringResource(id = "Sep 22"))
            }

            Column (
                modifier = Modifier.padding(horizontal = 11.dp),
                horizontalAlignment = Alignment.Start,

                ){

                Text(text = stringResource(id = R.string.label_high))
                Text(text = stringResource(id = R.string.label_humidity))
                Text(text = stringResource(id = R.string.label_pressure))


            }
            Column (
                modifier = Modifier.padding(horizontal = 11.dp),
                horizontalAlignment = Alignment.Start,

                ){

                Text(text = stringResource(id = R.string.high_temp, forecastConditions.forecast.forecastTemp[0]))
                Text(text = stringResource(id = R.string.label_humidity, forecastConditions.forecast.humidity.toInt()))
                Text(text = stringResource(id = R.string.label_pressure, forecastConditions.forecast.pressure.toInt()))


            }


            Spacer(modifier = Modifier.weight(1.0f, true))

            Column (
                modifier = Modifier.padding(horizontal = 11.dp),
                horizontalAlignment = Alignment.Start,

                    ){

                Text(text = stringResource(id = R.string.label_sunrise))
                Text(text = stringResource(id = R.string.label_sunset))
            }


        }
        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onBackButtonClick) {
            Text(text = stringResource(id = R.string.back))
        }
    }
}

@Preview(
    "ForecastConditions",
    device = Devices.PIXEL_4,
    showBackground = true,
    showSystemUi = true,
)

@Composable
fun ForecastConditionsScreenPreview(){
    ForecastConditions{}
}
