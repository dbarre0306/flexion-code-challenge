package com.dbarre.flexion.temperature;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TemperatureSpec {

    @Test
    public void shouldIndicateThatTwoTemperaturesAreNearEqual() {
        // given
        Celsius celsius1 = new Celsius(10);
        Celsius celsius2 = new Celsius(10.1);
        Celsius celsius3 = new Celsius(9.5);

        // expect
        assertTrue(celsius1.isNearEqualTo(celsius2));
        assertTrue(celsius1.isNearEqualTo(celsius3));
        assertTrue(celsius2.isNearEqualTo(celsius3));
    }

    @Test
    public void shouldIndicateThatTwoTemperaturesAreNotEqual() {
        // given
        Temperature celsius1 = new Celsius(10);
        Temperature celsius2 = new Celsius(9.4);
        Temperature fahrenheit = new Fahrenheit(10);

        // expect
        assertFalse(celsius1.isNearEqualTo(celsius2));
        assertFalse(celsius1.isNearEqualTo(fahrenheit));
        assertFalse(fahrenheit.isNearEqualTo(celsius2));
    }
}
