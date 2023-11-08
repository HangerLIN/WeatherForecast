package com.lth.weather.service;

import com.lth.weather.Utils.ResData;


public interface WeatherService {
    ResData getWeatherData(String cityName);
}
