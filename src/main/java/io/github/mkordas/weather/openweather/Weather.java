package io.github.mkordas.weather.openweather;

public class Weather {
    public final String date;
    public final String city;
    public final String weatherDescription;
    public final String sunriseHour;
    public final String sunsetHour;
    public final String temperatureCelsius;
    public final String temperatureFahrenheit;

    public Weather(Builder builder) {
        this.date = builder.date;
        this.city = builder.city;
        this.weatherDescription = builder.weatherDescription;
        this.sunriseHour = builder.sunriseHour;
        this.sunsetHour = builder.sunsetHour;
        this.temperatureCelsius = builder.temperatureCelsius;
        this.temperatureFahrenheit = builder.temperatureFahrenheit;
    }

    public static class Builder {
        private String date;
        private String city;
        private String weatherDescription;
        private String sunriseHour;
        private String sunsetHour;
        private String temperatureCelsius;
        private String temperatureFahrenheit;

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withWeatherDescription(String weatherDescription) {
            this.weatherDescription = weatherDescription;
            return this;
        }

        public Builder withSunriseHour(String sunriseHour) {
            this.sunriseHour = sunriseHour;
            return this;
        }

        public Builder withSunsetHour(String sunsetHour) {
            this.sunsetHour = sunsetHour;
            return this;
        }

        public Builder withTemperatureCelsius(String temperatureCelsius) {
            this.temperatureCelsius = temperatureCelsius;
            return this;
        }

        public Builder withTemperatureFahrenheit(String temperatureFahrenheit) {
            this.temperatureFahrenheit = temperatureFahrenheit;
            return this;
        }

        public Weather build() {
            return new Weather(this);
        }

    }
}