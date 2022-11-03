package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentCurrentConditionsBinding

class CurrentConditionsFragment : Fragment(R.layout.fragment_current_conditions) {

    private lateinit var binding: FragmentCurrentConditionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCurrentConditionsBinding.bind(view)

        binding.forecastButton.setOnClickListener {
            val forecast = Forecast(temp = "101")
            val action = CurrentConditionsFragmentDirections.actionCurrentConditionsFragmentToForecastFragment(forecast)
            findNavController().navigate(action)
        }
    }
}