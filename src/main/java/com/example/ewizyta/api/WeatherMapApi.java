package com.example.ewizyta.api;

import com.example.ewizyta.api.weatherDtos.WeatherDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Component
public class WeatherMapApi implements WeatherApi{

    private final static String URI = "https://api.weatherapi.com/v1/current.json";

    @Value("${weather.apikey}")
    private String apiKey;
    private String city;

    private String getUrl() {
        return UriComponentsBuilder.fromHttpUrl(URI)
                .queryParam("key", "{key}")
                .queryParam("q", "{q}")
                .queryParam("lang", "{lang}")
                .encode()
                .toUriString();
    }

    private Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();

        params.put("key", this.apiKey);
        params.put("q", this.city);
        params.put("lang", "pl");

        return params;
    }

    @Override
    public String fetchJsonData() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    this.getUrl(),
                    HttpMethod.GET,
                    httpEntity,
                    String.class,
                    getParams());

            return response.getBody();

        } catch (HttpClientErrorException ex) {
            if (ex.getRawStatusCode() == 404) {
                throw new NoSuchElementException("City not found");
            } else {
                throw new IllegalArgumentException("unexpected error occurred, try again");
            }
        }
    }

    @Override
    public WeatherDto getWeatherDto() throws JsonProcessingException {
        WeatherDto weatherDto = new ObjectMapper().readValue(this.fetchJsonData(), WeatherDto.class);

        return new WeatherDto(
                weatherDto.getLocation(),
                weatherDto.getCurrent()
        );
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }
}
