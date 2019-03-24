package com.dbarre.flexion.temperature;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.springframework.web.context.request.FacesRequestAttributes;

import static org.junit.Assert.assertThat;

public class CelsiusSpec {

    @Test
    public void shouldConvertToFahrenheit() {
        // given
        Celsius celsius = new Celsius(0);

        // expect
        assertThat(celsius.convert(TemperatureUnits.FAHRENHEIT), IsEqual.equalTo(new Fahrenheit(32)));
    }

    @Test
    public void shouldConvertToCelsius() {
        // given
        Celsius celsius = new Celsius(32);

        // expect
        assertThat(celsius.convert(TemperatureUnits.CELSIUS), IsEqual.equalTo(celsius));
    }

    @Test
    public void shouldConvertToKelvin() {
        // given
        Celsius celsius = new Celsius(0);

        // expect
        assertThat(celsius.convert(TemperatureUnits.KELVIN), IsEqual.equalTo(new Kelvin(273.15)));
    }
}
