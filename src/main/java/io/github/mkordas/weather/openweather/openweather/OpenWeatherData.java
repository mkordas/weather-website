package io.github.mkordas.weather.openweather.openweather;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.mkordas.weather.openweather.Weather;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.ZoneOffset.UTC;
import static java.time.format.DateTimeFormatter.ISO_DATE;

@JsonDeserialize(using = OpenWeatherResponseDeserializer.class)
public class OpenWeatherData {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("hh:mma")
            .withZone(UTC);

    public String city;
    public long sunrise;
    public long sunset;
    public long timezoneOffset;
    public double temperature;
    public String weatherDescription;

    public Weather asWeather() {
        KelvinDegrees kelvinDegrees = new KelvinDegrees(temperature);
        return new Weather.Builder()
                .withCity(city)
                .withDate(LocalDate.now().format(ISO_DATE))
                .withWeatherDescription(weatherDescription)
                .withSunriseHour(formatAsAmPmHour(sunrise + timezoneOffset))
                .withSunsetHour(formatAsAmPmHour(sunset + timezoneOffset))
                .withTemperatureCelsius(kelvinDegrees.asCelsius())
                .withTemperatureFahrenheit(kelvinDegrees.asFahrenheit())
                .build();
    }

    private static String formatAsAmPmHour(long timestamp) {
        return DATE_TIME_FORMATTER.format(Instant.ofEpochSecond(timestamp)).toLowerCase();
    }
}
