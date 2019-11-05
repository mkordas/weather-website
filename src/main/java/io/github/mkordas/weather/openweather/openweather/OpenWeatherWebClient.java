package io.github.mkordas.weather.openweather.openweather;

import io.github.mkordas.weather.openweather.WeatherWebClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class OpenWeatherWebClient implements WeatherWebClient {
    private static final String API_KEY = "f1661b8714b5031939fc9ff571135c10";
    private final WebClient client = WebClient.create("https://api.openweathermap.org");

    @Override
    public Mono<OpenWeatherData> weatherForCity(String city) {
        Mono<OpenWeatherData> mono = client.get()
                .uri("/data/2.5/weather?q={city}&APPID={APIKEY}", city, API_KEY)
                .retrieve().bodyToMono(OpenWeatherData.class);
        return mono;
    }
}
