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
            default:
                // should  never get here unless new units are added
                throw new RuntimeException();
        }
    }
}
