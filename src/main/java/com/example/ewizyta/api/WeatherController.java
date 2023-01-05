package com.example.ewizyta.api;

import com.example.ewizyta.api.weatherDtos.WeatherThymeleafDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    String weather(@PathVariable("city") String city, Model model) throws JsonProcessingException {

        WeatherThymeleafDto weather = weatherService.getWeather(city);

        model.addAttribute("weather", weather);

        return "weather";
    }
}
