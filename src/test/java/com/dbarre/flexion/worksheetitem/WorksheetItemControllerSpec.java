package com.dbarre.flexion.worksheetitem;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorksheetItemControllerSpec {

    @Mock
    private Model model;

    @Mock
    private ModelMap modelMap;

    @Mock
    private WorksheetItemFactory worksheetItemFactory;

    @Mock
    private WorksheetItemService worksheetItemService;

    @InjectMocks
    private WorksheetItemController worksheetItemController;

    private WorksheetItem worksheetItem = WorksheetItem.builder().build();

    @Test
    public void shouldGetDefaultWorkItemInput() {

        // when
        String path = worksheetItemController.index(model);

        // then
        assertThat(path, IsEqual.equalTo("index"));
        verify(model, times(1)).addAttribute("worksheetItem", new WorksheetItemInput());
    }

    @Test
    public void shouldGetInvalidResponse() {

        // given
        WorksheetItemInput input = new WorksheetItemInput();
        when(worksheetItemFactory.toWorksheetItem(input)).thenThrow(new WorksheetItemInputException());

        // when
        String path = worksheetItemController.submitWorksheetItem(input, modelMap);

        // then
        assertThat(path, IsEqual.equalTo("result"));
        verify(modelMap, times(1)).addAttribute("worksheetItem", input);
        verify(modelMap, times(1)).addAttribute("output", "invalid");
    }

    @Test
    public void shouldGetIncorrectResponse() {

        // given
        WorksheetItemInput input = new WorksheetItemInput();
        when(worksheetItemFactory.toWorksheetItem(input)).thenReturn(worksheetItem);
        when(worksheetItemService.isCorrect(worksheetItem)).thenReturn(false);

        // when
        String path = worksheetItemController.submitWorksheetItem(input, modelMap);

        // then
        assertThat(path, IsEqual.equalTo("result"));
        verify(modelMap, times(1)).addAttribute("worksheetItem", input);
        verify(modelMap, times(1)).addAttribute("output", "incorrect");
    }

    @Test
    public void shouldGetCorrectResponse() {

        // given
        WorksheetItemInput input = new WorksheetItemInput();
        when(worksheetItemFactory.toWorksheetItem(input)).thenReturn(worksheetItem);
        when(worksheetItemService.isCorrect(worksheetItem)).thenReturn(true);

        // when
        String path = worksheetItemController.submitWorksheetItem(input, modelMap);

        // then
        assertThat(path, IsEqual.equalTo("result"));
        verify(modelMap, times(1)).addAttribute("worksheetItem", input);
        verify(modelMap, times(1)).addAttribute("output", "correct");
    }
}
