package com.example.ewizyta.api;

import com.example.ewizyta.api.weatherDtos.WeatherDto;
import com.example.ewizyta.api.weatherDtos.WeatherThymeleafDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherApi weatherApi;

    public WeatherService(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public WeatherThymeleafDto getWeather(String city) throws JsonProcessingException {
        weatherApi.setCity(city);
        WeatherDto weatherDto = weatherApi.getWeatherDto();

        return WeatherMapper.map(weatherDto);
    }
}
