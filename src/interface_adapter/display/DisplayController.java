package interface_adapter.display;

import entity.Recipe;
import use_case.display.DisplayInputBoundary;
import use_case.display.DisplayInputData;

public class DisplayController {
    final DisplayInputBoundary displayInteractor;

    public DisplayController(DisplayInputBoundary displayInteractor){
        this.displayInteractor = displayInteractor;
    }

    public void execute(Integer recipeID) {
        DisplayInputData displayInputData= new DisplayInputData(recipeID);
        displayInteractor.execute(displayInputData);
    }
}
