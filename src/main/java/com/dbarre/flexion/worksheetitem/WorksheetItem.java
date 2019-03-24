package com.dbarre.flexion.worksheetitem;

import com.dbarre.flexion.temperature.TemperatureUnits;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorksheetItem {

    private double inputTemperature;
    private TemperatureUnits inputUnits;
    private TemperatureUnits targetUnits;
    private String studentAnswer;
}
