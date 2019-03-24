package com.dbarre.flexion.temperature;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class Fahrenheit extends Temperature {

    public Fahrenheit(double value) {
        super(value);
    }

    @Override
    public Temperature convert(TemperatureUnits targetUnits) {
        switch (targetUnits) {
            case FAHRENHEIT: return this;
            case CELSIUS: return toCelsius();
            case KELVIN: return toKelvin();
            case RANKINE: return toRankine();
            default:
                // should  never get here unless new units are added
                throw new RuntimeException();
        }
    }

    private Temperature toCelsius() {
        return new Celsius(celsiusToFahrenheit());
    }

    private Temperature toKelvin() {
        return new Kelvin(celsiusToFahrenheit() + CELSIUS_TO_KELVIN);
    }

    private Temperature toRankine() {
        return new Rankine(value + FAHRENHEIT_TO_RANKINE);
    }

    private double celsiusToFahrenheit() {
        return (value - 32) * 5.0 / 9.0;
    }
}
