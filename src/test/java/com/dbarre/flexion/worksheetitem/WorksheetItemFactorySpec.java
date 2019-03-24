package com.dbarre.flexion.worksheetitem;

import com.dbarre.flexion.temperature.TemperatureUnits;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class WorksheetItemFactorySpec {

    private final WorksheetItemFactory worksheetItemFactory = new WorksheetItemFactory();

    @Test
    public void shouldSuccessfullyCreateWorksheetItem() {

        // given
        WorksheetItemInput input = new WorksheetItemInput();
        input.setInputTemperature("55");
        input.setStudentAnswer("33");

        // when
        WorksheetItem worksheetItem = worksheetItemFactory.toWorksheetItem(input);

        // then
        assertThat(worksheetItem.getInputTemperature(), IsEqual.equalTo(55.0));
        assertThat(worksheetItem.getInputUnits(), IsEqual.equalTo(TemperatureUnits.FAHRENHEIT));
        assertThat(worksheetItem.getTargetUnits(), IsEqual.equalTo(TemperatureUnits.FAHRENHEIT));
        assertThat(worksheetItem.getStudentAnswer(), IsEqual.equalTo(input.getStudentAnswer()));
    }

    @Test(expected = WorksheetItemInputException.class)
    public void shouldFailIfInputTemperatureIsNotNumber() {

        // given
        WorksheetItemInput input = new WorksheetItemInput();
        input.setInputTemperature("foo");
        input.setStudentAnswer("33");

        // when
        worksheetItemFactory.toWorksheetItem(input);
    }

    @Test(expected = WorksheetItemInputException.class)
    public void shouldFailIfInputUnitsIsInvalid() {

        // given
        WorksheetItemInput input = new WorksheetItemInput();
        input.setInputTemperature("55");
        input.setInputUnits("1");
        input.setStudentAnswer("33");

        // when
        worksheetItemFactory.toWorksheetItem(input);
    }

    @Test(expected = WorksheetItemInputException.class)
    public void shouldFailIfTargetUnitsIsInvalid() {

        // given
        WorksheetItemInput input = new WorksheetItemInput();
        input.setInputTemperature("55");
        input.setTargetUnits("1");
        input.setStudentAnswer("33");

        // when
        worksheetItemFactory.toWorksheetItem(input);
    }
}
