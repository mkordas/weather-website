package io.github.mkordas.weather.openweather;

import io.github.mkordas.weather.openweather.openweather.OpenWeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {
    private final WeatherWebClient client;

    @Autowired
    public WeatherController(WeatherWebClient client) {
        this.client = client;
    }

    @GetMapping("weather/{city}")
    private Mono<Weather> weatherForCity(@PathVariable String city) {
        return client.weatherForCity(city).map(OpenWeatherData::asWeather);
    }

}
