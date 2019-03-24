package com.dbarre.flexion.worksheetitem;

import com.dbarre.flexion.temperature.Temperature;
import com.dbarre.flexion.temperature.TemperatureFactory;
import com.dbarre.flexion.util.NumericUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WorksheetItemService {

    private final TemperatureFactory temperatureFactory;

    public WorksheetItemService(final TemperatureFactory temperatureFactory) {
        this.temperatureFactory = temperatureFactory;
    }

    public boolean isCorrect(final WorksheetItem worksheetItem) {
        log.info("IsCorrect: " + worksheetItem);

        return NumericUtil.isNumeric(worksheetItem.getStudentAnswer())
                && isCorrectAnswer(worksheetItem);
    }

    private boolean isCorrectAnswer(final WorksheetItem worksheetItem) {
        Temperature inputTemperature = this.temperatureFactory.toTemperature(
                worksheetItem.getInputTemperature(),
                worksheetItem.getInputUnits());

        log.info("inputTemperature: " + inputTemperature);

        Temperature authoritativeTemperature = inputTemperature.convert(worksheetItem.getTargetUnits());

        log.info("authoritativeTemperature: " + authoritativeTemperature);

        Temperature studentTemperature = this.temperatureFactory.toTemperature(
                Double.valueOf(worksheetItem.getStudentAnswer()),
                worksheetItem.getTargetUnits());

        log.info("studentTemperature: " + studentTemperature);

        return authoritativeTemperature.isNearEqualTo(studentTemperature);
    }
}
