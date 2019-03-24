package com.dbarre.flexion.temperature;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Temperature {

    protected static final double CELSIUS_TO_KELVIN = 273.15;
    protected static final double FAHRENHEIT_TO_RANKINE = 459.67;

    protected double value;

    public abstract Temperature convert(TemperatureUnits targetUnits);

    public boolean isNearEqualTo(Temperature otherTemperature) {
        return Math.round(value) == Math.round(otherTemperature.value)
                && this.getClass().equals(otherTemperature.getClass());
    }
}
