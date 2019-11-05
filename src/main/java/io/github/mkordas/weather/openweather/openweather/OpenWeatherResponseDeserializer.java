package io.github.mkordas.weather.openweather.openweather;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class OpenWeatherResponseDeserializer extends StdDeserializer<OpenWeatherData> {

    public OpenWeatherResponseDeserializer() {
        this(null);
    }

    public OpenWeatherResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public OpenWeatherData deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        OpenWeatherData openWeatherData = new OpenWeatherData();
        openWeatherData.city = rootNode.get("name").textValue();
        JsonNode sysNode = rootNode.get("sys");
        openWeatherData.sunrise = sysNode.get("sunrise").longValue();
        openWeatherData.sunset = sysNode.get("sunset").longValue();
        openWeatherData.timezoneOffset = rootNode.get("timezone").longValue();
        JsonNode mainNode = rootNode.get("main");
        openWeatherData.temperature = mainNode.get("temp").doubleValue();
        openWeatherData.weatherDescription = rootNode.get("weather").get(0).get("description").textValue();
        return openWeatherData;
    }
}
