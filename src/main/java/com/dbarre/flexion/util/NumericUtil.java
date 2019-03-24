package com.dbarre.flexion.util;

public class NumericUtil {

    public static boolean isNumeric(String value) {
        try {
            if (value == null) return false;
            Double.valueOf(value);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
