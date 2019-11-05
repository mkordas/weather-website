package io.github.mkordas.weather.openweather

import io.github.mkordas.weather.openweather.openweather.KelvinDegrees
import spock.lang.Specification

class KelvinDegreesTest extends Specification {
    def "converts kelvins to celsius and fahrenheit degrees"() {
        def kelvinDegrees = new KelvinDegrees(kelvin.toDouble())
        expect:
        kelvinDegrees.asCelsius() == celsius
        kelvinDegrees.asFahrenheit() == fahrenheit
        where:
        kelvin   | celsius   | fahrenheit
        "0"      | "-273.15" | "-459.67"
        "273.15" | "0"       | "32"
        "300"    | "26.85"   | "80.33"
    }
}
