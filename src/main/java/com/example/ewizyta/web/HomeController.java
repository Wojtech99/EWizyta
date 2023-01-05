package com.example.ewizyta.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    String home() {
        return "index";
    }

    @PostMapping("/go-to-weather")
    String findWeather(@RequestParam("city") String city) {
        return "redirect:/weather/" + city;
    }
}
