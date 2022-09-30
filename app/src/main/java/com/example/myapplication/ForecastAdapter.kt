package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class ForecastAdapter(private val data: List<DayForecast>) : RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item, parent, false)
        return ForecastViewHolder(view)

    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val forecastTemp: TextView
    private val forecastHumidity: TextView
    private val forecastDate: TextView
    private val sunrise: TextView
    private val sunset: TextView
    private val highTemp: TextView
    private val forecastPressure: TextView

    init {
        forecastDate = view.findViewById(R.id.forecast_date)
        forecastTemp = view.findViewById(R.id.forecast_temp)
        forecastHumidity = view.findViewById(R.id.forecast_humidity)
        sunrise = view.findViewById(R.id.sunrise)
        sunset = view.findViewById(R.id.sunset)
        highTemp = view.findViewById(R.id.high_temp)
        forecastPressure = view.findViewById(R.id.forecast_pressure)
    }

    fun bind(data: DayForecast){

        val dateTimestamp = data.date
        val sunsetTime = data.sunset
        val formatter = DateTimeFormatter.ofPattern("MMM dd")

        val sunsetDayTime = LocalDateTime.ofEpochSecond(sunsetTime,0, ZoneOffset.of("-5"))
        val dateTime = LocalDateTime.ofEpochSecond(dateTimestamp, 0, ZoneOffset.of("-5"))
        val formattedDate = formatter.format(dateTime)

        val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")
        val formattedTime = timeFormatter.format(dateTime)
        val formattedSunset = timeFormatter.format(sunsetDayTime)


        Log.d("ForecastFragment", formattedDate) //
        Log.d("ForecastFragment",formattedTime) //
        Log.d("ForecastFragment", formattedSunset)

        val tmp = 0x00B0.toChar()
        val percent ="%"

        forecastPressure.text = data.pressure.toString()
        highTemp.text = data.temp.max.toString().plus(tmp)
        sunset.text = formattedSunset.toString()
        sunrise.text = formattedTime.toString()
        forecastDate.text = formattedDate.toString()
        forecastHumidity.text = data.humidity.toString().plus(percent)
        forecastTemp.text = data.temp.min.toString().plus(tmp)
    }
}