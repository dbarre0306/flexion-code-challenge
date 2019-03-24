package com.dbarre.flexion.temperature;

import org.springframework.stereotype.Component;

@Component
public class TemperatureFactory {

    public Temperature toTemperature(double temperature, TemperatureUnits temperatureUnits) {
        switch (temperatureUnits) {
            case FAHRENHEIT: return new Fahrenheit(temperature);
            case CELSIUS: return new Celsius(temperature);
            default:
                throw new RuntimeException();
        }
    }
}
