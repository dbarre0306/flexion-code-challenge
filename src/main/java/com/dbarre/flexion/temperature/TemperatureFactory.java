package com.dbarre.flexion.temperature;

import org.springframework.stereotype.Component;

@Component
public class TemperatureFactory {

    public Temperature toTemperature(double temperature, TemperatureUnits temperatureUnits) {
        switch (temperatureUnits) {
            case FAHRENHEIT: return new Fahrenheit(temperature);
            default:
                throw new RuntimeException();
        }
    }
}
