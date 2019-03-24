package com.dbarre.flexion.worksheetitem;

import com.dbarre.flexion.temperature.Fahrenheit;
import com.dbarre.flexion.temperature.TemperatureFactory;
import com.dbarre.flexion.temperature.TemperatureUnits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorksheetItemServiceSpec {

    @Mock
    private TemperatureFactory temperatureFactory;

    @InjectMocks
    private WorksheetItemService worksheetItemService;

    @Test
    public void shouldBeCorrectIfStudentGetsExactAnswer() {
        // given
        WorksheetItem worksheetItem = WorksheetItem.builder()
                .inputTemperature(55)
                .inputUnits(TemperatureUnits.FAHRENHEIT)
                .targetUnits(TemperatureUnits.FAHRENHEIT)
                .studentAnswer("55")
                .build();

        when(temperatureFactory.toTemperature(55, worksheetItem.getInputUnits())).thenReturn(new Fahrenheit(55));

        // expect
        assertTrue(worksheetItemService.isCorrect(worksheetItem));
    }

    @Test
    public void shouldBeCorrectIfStudentGetsCloseAnswer() {
        WorksheetItem worksheetItem = WorksheetItem.builder()
                .inputTemperature(55.1)
                .inputUnits(TemperatureUnits.FAHRENHEIT)
                .targetUnits(TemperatureUnits.FAHRENHEIT)
                .studentAnswer("55.4")
                .build();

        when(temperatureFactory.toTemperature(55.1, worksheetItem.getInputUnits())).thenReturn(new Fahrenheit(55.1));
        when(temperatureFactory.toTemperature(55.4, worksheetItem.getInputUnits())).thenReturn(new Fahrenheit(55.4));

        // expect
        assertTrue(worksheetItemService.isCorrect(worksheetItem));
    }

    @Test
    public void shouldBeIncorrectIfStudentAnswerIsNotNumeric() {
        // given
        WorksheetItem worksheetItem = WorksheetItem.builder()
                .inputTemperature(55)
                .inputUnits(TemperatureUnits.FAHRENHEIT)
                .targetUnits(TemperatureUnits.FAHRENHEIT)
                .studentAnswer("foo")
                .build();

        // expect
        assertFalse(worksheetItemService.isCorrect(worksheetItem));
    }

    @Test
    public void shouldBeIncorrectIfStudentAnswerIsWrong() {
        WorksheetItem worksheetItem = WorksheetItem.builder()
                .inputTemperature(55.1)
                .inputUnits(TemperatureUnits.FAHRENHEIT)
                .targetUnits(TemperatureUnits.FAHRENHEIT)
                .studentAnswer("60.4")
                .build();

        when(temperatureFactory.toTemperature(55.1, worksheetItem.getInputUnits())).thenReturn(new Fahrenheit(55.1));
        when(temperatureFactory.toTemperature(60.4, worksheetItem.getInputUnits())).thenReturn(new Fahrenheit(60.4));

        // expect
        assertFalse(worksheetItemService.isCorrect(worksheetItem));
    }
}
