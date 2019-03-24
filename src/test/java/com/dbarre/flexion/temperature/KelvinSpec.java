package com.dbarre.flexion.temperature;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class KelvinSpec {

    @Test
    public void shouldConvertToFahrenheit() {
        // given
        Kelvin kelvin = new Kelvin(273.15);

        // expect
        assertThat(kelvin.convert(TemperatureUnits.FAHRENHEIT), IsEqual.equalTo(new Fahrenheit(32)));
    }

    @Test
    public void shouldConvertToCelsius() {
        // given
        Kelvin kelvin = new Kelvin(273.15);

        // expect
        assertThat(kelvin.convert(TemperatureUnits.CELSIUS), IsEqual.equalTo(new Celsius(0)));
    }

    @Test
    public void shouldConvertToKelvin() {
        // given
        Kelvin kelvin = new Kelvin(273.15);

        // expect
        assertThat(kelvin.convert(TemperatureUnits.KELVIN), IsEqual.equalTo(kelvin));
    }
}
