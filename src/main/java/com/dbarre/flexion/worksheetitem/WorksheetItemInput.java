package com.dbarre.flexion.worksheetitem;

import lombok.Data;

@Data
public class WorksheetItemInput {

    private String inputTemperature;
    private String inputUnits = "F";
    private String targetUnits = "F";
    private String studentAnswer;
}
