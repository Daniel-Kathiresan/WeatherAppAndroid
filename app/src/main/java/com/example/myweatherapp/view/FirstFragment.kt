package com.example.myweatherapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myweatherapp.R
import com.example.myweatherapp.databinding.FragmentFirstBinding
import com.example.myweatherapp.network.ApiInterface
import com.example.myweatherapp.repository.WeatherRepository
import com.example.myweatherapp.view.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: MainViewModel


    @SuppressLint("PrivateResource")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        val apiInterface = ApiInterface.getInstance()
        val weatherRepository = WeatherRepository(apiInterface)
        viewModel = MainViewModel(weatherRepository)
        val view = com.google.android.material.R.layout.mtrl_layout_snackbar
        viewModel.weather.observe(viewLifecycleOwner) {
            Log.d("Debug!!", it.toString())

        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}