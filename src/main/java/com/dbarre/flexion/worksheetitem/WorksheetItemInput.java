package com.dbarre.flexion.worksheetitem;

import lombok.Data;

@Data
public class WorksheetItemInput {

    private String inputTemperature;
    private String inputUnits = "Fahrenheit";
    private String targetUnits = "Fahrenheit";
    private String studentAnswer;
}
