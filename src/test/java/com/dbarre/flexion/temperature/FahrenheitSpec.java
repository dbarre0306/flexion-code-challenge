package com.dbarre.flexion.temperature;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class FahrenheitSpec {

    @Test
    public void shouldConvertFahrenheitToFahrenheit() {
        // given
        Fahrenheit fahrenheit = new Fahrenheit(56.7);

        // when
        Temperature temperature = fahrenheit.convert(TemperatureUnits.FAHRENHEIT);

        // then
        assertThat(temperature, IsEqual.equalTo(fahrenheit));
    }
}
