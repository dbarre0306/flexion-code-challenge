package com.dbarre.flexion.worksheetitem;

import com.dbarre.flexion.temperature.Temperature;
import com.dbarre.flexion.temperature.TemperatureFactory;
import com.dbarre.flexion.util.NumericUtil;
import org.springframework.stereotype.Component;

@Component
public class WorksheetItemService {

    private final TemperatureFactory temperatureFactory;

    public WorksheetItemService(final TemperatureFactory temperatureFactory) {
        this.temperatureFactory = temperatureFactory;
    }

    public boolean isCorrect(final WorksheetItem worksheetItem) {
        return NumericUtil.isNumeric(worksheetItem.getStudentAnswer())
                && isCorrectAnswer(worksheetItem);
    }

    private boolean isCorrectAnswer(final WorksheetItem worksheetItem) {
        Temperature inputTemperature = this.temperatureFactory.toTemperature(
                worksheetItem.getInputTemperature(),
                worksheetItem.getInputUnits());

        Temperature authoritativeTemperature = inputTemperature.convert(worksheetItem.getTargetUnits());

        Temperature studentTemperature = this.temperatureFactory.toTemperature(
                Double.valueOf(worksheetItem.getStudentAnswer()),
                worksheetItem.getTargetUnits());

        return authoritativeTemperature.isNearEqualTo(studentTemperature);
    }
}
