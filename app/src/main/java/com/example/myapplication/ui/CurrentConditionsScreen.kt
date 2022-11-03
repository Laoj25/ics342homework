package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


@Composable
fun CurrentConditionsScreen(
    cityName: String,
    temperature: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = cityName,
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
                text = temperature,
                style = TextStyle(
                    fontSize = 72.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Start
                )

            )
            

            Spacer(modifier = Modifier.weight(1.0f, true))
            Image(
                modifier = Modifier
                    .size(72.dp),
                painter = painterResource(id = R.drawable.sun_icon),
                contentDescription = "Sunny",
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = stringResource(id = R.string.Feels_like),
                Modifier.padding(horizontal = 35.dp))

            Text(
                text = stringResource(id = R.string.low_temp),

            )

            Text(
                text = stringResource(id = R.string.high_temp),

            )

            Text(
                text = stringResource(id = R.string.humidity),

            )

            Text(
                text = stringResource(id = R.string.pressure),
            )
        }
        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = {}) {
            Text(text = stringResource(id = R.string.forecast))
        }

    }
}
@Preview(
    "CurrentConditions",
    device = Devices.PIXEL_4,
    showBackground = true,
    showSystemUi = true,
)


@Composable
fun CurrentConditionsScreenPreview (){
    CurrentConditionsScreen(
        cityName = "Minneapolis, MN",
        temperature = "89",
    )
}
