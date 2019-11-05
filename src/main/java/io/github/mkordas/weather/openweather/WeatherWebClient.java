package io.github.mkordas.weather.openweather;

import io.github.mkordas.weather.openweather.openweather.OpenWeatherData;
import reactor.core.publisher.Mono;

public interface WeatherWebClient {
    Mono<OpenWeatherData> weatherForCity(String city);
}
