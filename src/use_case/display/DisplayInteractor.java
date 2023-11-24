package use_case.display;

import entity.Recipe;

public class DisplayInteractor implements DisplayInputBoundary{
    final DisplayOutputBoundary displayPresenter;


    public DisplayInteractor(DisplayOutputBoundary displayOutputBoundary){
        this.displayPresenter = displayOutputBoundary;
    }

    @Override
    public void execute(DisplayInputData displayInputData) {
        Integer recipeID =  displayInputData.getRecipeID();



    }
}