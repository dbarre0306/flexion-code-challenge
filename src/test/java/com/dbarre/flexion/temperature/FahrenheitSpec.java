package com.dbarre.flexion.temperature;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class FahrenheitSpec {

    @Test
    public void shouldConvertToFahrenheit() {
        // given
        Fahrenheit fahrenheit = new Fahrenheit(56.7);

        // expect
        assertThat(fahrenheit.convert(TemperatureUnits.FAHRENHEIT), IsEqual.equalTo(fahrenheit));
    }

    @Test
    public void shouldConvertToCelsius() {
        // given
        Fahrenheit fahrenheit = new Fahrenheit(32);

        // expect
        assertThat(fahrenheit.convert(TemperatureUnits.CELSIUS), IsEqual.equalTo(new Celsius(0)));
    }
}
