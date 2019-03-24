package com.dbarre.flexion.temperature;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.web.context.request.FacesRequestAttributes;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class Celsius extends Temperature {

    public Celsius(double value) {
        super(value);
    }

    @Override
    public Temperature convert(TemperatureUnits targetUnits) {
        switch (targetUnits) {
            case FAHRENHEIT: return toFahrenheit();
            case CELSIUS: return this;
            case KELVIN: return toKelvin();
            default:
                // should  never get here unless new units are added
                throw new RuntimeException();
        }
    }

    private Temperature toFahrenheit() {
        return new Fahrenheit((value * 9.0 / 5.0) + 32);
    }

    private Temperature toKelvin() {
        return new Kelvin(value + CELSIUS_TO_KELVIN);
    }
}
