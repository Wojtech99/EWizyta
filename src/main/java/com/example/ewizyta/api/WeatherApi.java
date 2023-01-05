package com.example.ewizyta.api;

import com.example.ewizyta.api.weatherDtos.WeatherDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherApi {
    String fetchJsonData();

    WeatherDto getWeatherDto() throws JsonProcessingException;

    void setCity(String city);
}
