package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
fun ForecastConditionsScreen(){
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
                modifier = Modifier
                    .size(72.dp),
                painter = painterResource(id = R.drawable.sun_icon),
                contentDescription = "Sunny",
            )
            Spacer(modifier = Modifier.weight(1.0f, true))

            Column (
                modifier = Modifier
                    .padding(horizontal = 11.dp),
                horizontalAlignment = Alignment.End,

                    ){

                Text(text = stringResource(id = R.string.label_high))
            }


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
    ForecastConditionsScreen()
}
