package com.dbarre.flexion.worksheetitem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class WorksheetItemController {

    private static final String CORRECT = "correct";
    private static final String INCORRECT = "incorrect";
    private static final String INVALID = "invalid";

    private final WorksheetItemFactory worksheetItemFactory;
    private final WorksheetItemService worksheetItemService;

    public WorksheetItemController(
            final WorksheetItemFactory worksheetItemFactory,
            final WorksheetItemService worksheetItemService) {

        this.worksheetItemFactory = worksheetItemFactory;
        this.worksheetItemService = worksheetItemService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("worksheetItem", new WorksheetItemInput());
        return "index";
    }

    @PostMapping("/worksheetItem")
    public String submitWorksheetItem(@ModelAttribute WorksheetItemInput worksheetItemInput, ModelMap model) {

        String output = getOutput(worksheetItemInput);
        model.addAttribute("worksheetItem", worksheetItemInput);
        model.addAttribute("output", output.toString().toLowerCase());
        return "result";
    }

    private String getOutput(WorksheetItemInput worksheetItemInput) {
        try {
            WorksheetItem worksheetItem = worksheetItemFactory.toWorksheetItem(worksheetItemInput);
            return worksheetItemService.isCorrect(worksheetItem) ? CORRECT : INCORRECT;
        }
        catch (WorksheetItemInputException e) {
            return INVALID;
        }
    }
}
