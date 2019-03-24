package com.dbarre.flexion.temperature;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class RankineSpec {

    @Test
    public void shouldConvertToFahrenheit() {
        // given
        Rankine rankine = new Rankine(1);

        // expect
        assertThat(rankine.convert(TemperatureUnits.FAHRENHEIT), IsEqual.equalTo(new Fahrenheit(-458.67)));
    }

    @Test
    public void shouldConvertToCelsius() {
        // given
        Rankine rankine = new Rankine(0);

        // expect
        assertThat(rankine.convert(TemperatureUnits.CELSIUS), IsEqual.equalTo(new Celsius(-273.15)));
    }

    @Test
    public void shouldConvertToKelvin() {
        // given
        Rankine rankine = new Rankine(9);

        // expect
        assertThat(rankine.convert(TemperatureUnits.KELVIN), IsEqual.equalTo(new Kelvin(5)));
    }

    @Test
    public void shouldConvertToRankine() {
        // given
        Rankine rankine = new Rankine(10);

        // expect
        assertThat(rankine.convert(TemperatureUnits.RANKINE), IsEqual.equalTo(rankine));
    }
}
