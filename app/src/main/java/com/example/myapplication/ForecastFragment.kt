package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentForecastBinding
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

val forecastData = listOf<DayForecast>(
    DayForecast(1664354541L,1664354541L,1664416521L, ForecastTemp(34, 45),30.7f,88),
    DayForecast(1664465781L,1664465781L,1664510541L, ForecastTemp(44, 65),34.6f,89),
    DayForecast(1654864221L,1654864221L,1654915521L, ForecastTemp(55, 63),60.5f,60),
    DayForecast(1641555861L,1641555861L,1641608601L,ForecastTemp(49, 78),66.5f,73),
    DayForecast(1666629554L,1666629554L,1641608601L,ForecastTemp(32, 55),22.3f,50),
    DayForecast(1669385714L,1669385714L,1669439894L,ForecastTemp(12, 49),89.9f,32),
    DayForecast(1672399214L,1672399214L,1672449914L,ForecastTemp(43, 50),12.7f,27),
    DayForecast(1672575434L,1672575434L,1672617194L,ForecastTemp(66, 90),62.1f,100),
    DayForecast(1676379554L,1676379554L,1676430194L,ForecastTemp(23, 48),49.7f,20),
    DayForecast(1678376594L,1678376594L,1678427354L,ForecastTemp(57, 67),90.8f,48),
    DayForecast(1681721714L,1681721714L,1681765274L,ForecastTemp(21, 33),53.3f,14),
    DayForecast(1683368954L,1683368954L,1683428474L,ForecastTemp(37, 51),82.5f,66),
    DayForecast(1687452074L,1687452074L,1687486694L,ForecastTemp(11, 20),23.5f,11),
    DayForecast(1704619394L,1704619394L,1704678434L,ForecastTemp(9, 12),73.9f,5),
    DayForecast(1708350734L,1708350734L,1708405874L,ForecastTemp(3, 8),83.5f,2),
    DayForecast(1702109654L,1702109654L,1702174694L,ForecastTemp(6, 15),60.0f,8),
    )


class ForecastFragment : Fragment(R.layout.fragment_forecast){

    private lateinit var binding: FragmentForecastBinding
    //private val args: ForecastFragmentArgs by navArgs()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        //binding.forecastTemp.text = args.forecast.temp
        binding.forecastList.adapter = ForecastAdapter(forecastData)


        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_forecastFragment_to_currentConditionsFragment)
            }
        }
    }
