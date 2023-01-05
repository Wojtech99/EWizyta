package com.example.ewizyta.api.weatherDtos;

public class WeatherThymeleafDto {
    private String city;
    private String country;
    private String locateDateTime;
    private double temperature;
    private double windSpeed;
    private double pressure;
    private int humidity;
    private int cloud;
    private String weatherText;
    private String icon;

    public WeatherThymeleafDto(String city, String country, String locateDateTime,
                               double temperature, double windSpeed, double pressure,
                               int humidity, int cloud, String weatherText, String icon) {
        this.city = city;
        this.country = country;
        this.locateDateTime = locateDateTime;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.humidity = humidity;
        this.cloud = cloud;
        this.weatherText = weatherText;
        this.icon = icon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocateDateTime() {
        return locateDateTime;
    }

    public void setLocateDateTime(String locateDateTime) {
        this.locateDateTime = locateDateTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
