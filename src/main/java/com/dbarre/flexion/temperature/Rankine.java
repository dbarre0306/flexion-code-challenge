package com.dbarre.flexion.temperature;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class Rankine extends Temperature {

    public Rankine(double value) {
        super(value);
    }

    @Override
    public Temperature convert(TemperatureUnits targetUnits) {
        switch (targetUnits) {
            case FAHRENHEIT: return toFahrenheit();
            case CELSIUS: return toCelsius();
            case KELVIN: return toKelvin();
            case RANKINE: return this;
            default:
                // should  never get here unless new units are added
                throw new RuntimeException();
        }
    }

    private Temperature toFahrenheit() {
        return new Fahrenheit(value - FAHRENHEIT_TO_RANKINE);
    }

    private Temperature toCelsius() {
        return new Celsius((value - 32 - FAHRENHEIT_TO_RANKINE) * 5.0 / 9.0);
    }

    private Temperature toKelvin() {
        return new Kelvin(value * 5.0 / 9.0);
    }
}
