package com.dbarre.flexion.worksheetitem;

import com.dbarre.flexion.temperature.TemperatureUnits;
import org.springframework.stereotype.Component;

@Component
public class WorksheetItemFactory {

    public WorksheetItem toWorksheetItem(WorksheetItemInput worksheetItemInput) {
        return WorksheetItem.builder()
                .inputTemperature(toDouble(worksheetItemInput.getInputTemperature()))
                .inputUnits(toTemperatureUnits(worksheetItemInput.getInputUnits()))
                .targetUnits(toTemperatureUnits(worksheetItemInput.getTargetUnits()))
                .studentAnswer(worksheetItemInput.getStudentAnswer())
                .build();
    }

    private double toDouble(String value) {
        try {
            return Double.valueOf(value);
        }
        catch (NumberFormatException e) {
            throw new WorksheetItemInputException();
        }
    }

    private TemperatureUnits toTemperatureUnits(String units) {
        switch (units) {
            case "Fahrenheit": return TemperatureUnits.FAHRENHEIT;
            case "Celsius": return TemperatureUnits.CELSIUS;
            default:
                throw new WorksheetItemInputException();
        }
    }
}
