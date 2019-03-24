package com.dbarre.flexion.temperature;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class Kelvin extends Temperature {

    public Kelvin(double value) {
        super(value);
    }

    @Override
    public Temperature convert(TemperatureUnits targetUnits) {
        switch (targetUnits) {
            case FAHRENHEIT: return toFahrenheit();
            case CELSIUS: return toCelsius();
            case KELVIN: return this;
            default:
                // should  never get here unless new units are added
                throw new RuntimeException();
        }
    }

    private Temperature toFahrenheit() {
        return new Fahrenheit((value - CELSIUS_TO_KELVIN) * 9.0 / 5.0 + 32);
    }

    private Temperature toCelsius() {
        return new Celsius(value - CELSIUS_TO_KELVIN);
    }
}
