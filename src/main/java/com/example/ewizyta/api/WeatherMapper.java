package com.example.ewizyta.api;

import com.example.ewizyta.api.weatherDtos.WeatherDto;
import com.example.ewizyta.api.weatherDtos.WeatherThymeleafDto;

public class WeatherMapper {
    public static WeatherThymeleafDto map(WeatherDto weatherDto) {
        return new WeatherThymeleafDto(
                weatherDto.getLocation().getName(),
                weatherDto.getLocation().getCountry(),
                weatherDto.getLocation().getLocaltime(),
                weatherDto.getCurrent().getTemp_c(),
                weatherDto.getCurrent().getWind_kph(),
                weatherDto.getCurrent().getPressure_mb(),
                weatherDto.getCurrent().getHumidity(),
                weatherDto.getCurrent().getCloud(),
                weatherDto.getCurrent().getCondition().getText(),
                weatherDto.getCurrent().getCondition().getIcon()
        );
    }
}
