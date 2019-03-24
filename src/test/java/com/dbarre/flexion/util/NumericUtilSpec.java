package com.dbarre.flexion.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumericUtilSpec {

    @Test
    public void shouldBeNumeric() {
        assertTrue(NumericUtil.isNumeric("55.6"));
    }

    @Test
    public void shouldNotBeNumeric() {
        assertFalse(NumericUtil.isNumeric(null));
        assertFalse(NumericUtil.isNumeric(""));
        assertFalse(NumericUtil.isNumeric("foo"));
        assertFalse(NumericUtil.isNumeric("66.7x"));
    }
}
