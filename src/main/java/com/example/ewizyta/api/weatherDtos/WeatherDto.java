package com.example.ewizyta.api.weatherDtos;

public class WeatherDto {
    private WeatherLocationDto location;
    private WeatherCurrentDto current;

    public WeatherDto(){}

    public WeatherDto(WeatherLocationDto location, WeatherCurrentDto current) {
        this.location = location;
        this.current = current;
    }

    public WeatherLocationDto getLocation() {
        return location;
    }

    public void setLocation(WeatherLocationDto location) {
        this.location = location;
    }

    public WeatherCurrentDto getCurrent() {
        return current;
    }

    public void setCurrent(WeatherCurrentDto current) {
        this.current = current;
    }
}
