package com.example.draggerapppp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.draggerapppp.domain.location.LocationTracker
import com.example.draggerapppp.domain.repository.WeatherRepository
import com.example.draggerapppp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
):ViewModel() {
    var state by mutableStateOf(WeatherState())
    private set
    fun loadWeatherInfo(){
        viewModelScope.launch {
            state=state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let{
                when(val result=repository.getWeatherData(it.latitude,it.longitude)){
                    is Resource.Success->{
                        state=state.copy(
                            isLoading = false,
                            weatherInfo = result.data,
                            error = null
                        )
                    }
                    is Resource.Error->{
                       state=state.copy(
                           isLoading = false,
                           error = result.message,
                           weatherInfo = null
                       )
                    }
                }
            }?: kotlin.run {
                state=state.copy(
                    isLoading = false,
                    error = "Make sure Gps is enabled, cant retrieve location "
                )
            }
        }
    }
}