package com.dbarre.flexion.temperature;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

public class TemperatureFactorySpec {

    private TemperatureFactory temperatureFactory = new TemperatureFactory();

    @Test
    public void shouldCreateFahrenheitTemperature() {

        // when
        Temperature actualFahrenheit = temperatureFactory.toTemperature(56.7, TemperatureUnits.FAHRENHEIT);

        // then
        Fahrenheit expectedFahrenheit = new Fahrenheit(56.7);
        assertThat(actualFahrenheit, IsEqual.equalTo(expectedFahrenheit));
    }
}
