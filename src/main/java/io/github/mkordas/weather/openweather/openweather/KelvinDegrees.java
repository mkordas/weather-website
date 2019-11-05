package io.github.mkordas.weather.openweather.openweather;

import java.text.DecimalFormat;

public class KelvinDegrees {
    private final DecimalFormat decimalFormat = new DecimalFormat();
    private final double value;

    public KelvinDegrees(double value) {
        decimalFormat.setMaximumFractionDigits(2);
        this.value = value;
    }

    public String asFahrenheit() {
        return decimalFormat.format(value * 9 / 5 - 459.67);
    }

    public String asCelsius() {
        return decimalFormat.format(value - 273.15);

    }
}
