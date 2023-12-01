package use_case.display;


import entity.Recipe;
import use_case.TemporaryRecipeDataAccessInterface;


public class DisplayInteractor implements DisplayInputBoundary{
    final DisplayOutputBoundary displayPresenter;
    final TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject;


    public DisplayInteractor(TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject,
                             DisplayOutputBoundary displayOutputBoundary){
        this.displayPresenter = displayOutputBoundary;
        this.temporaryRecipeDataAccessObject = temporaryRecipeDataAccessObject;
    }

    @Override
    public void execute(DisplayInputData displayInputData) {
        Recipe recipe = null;
        try {
            Integer recipeID =  displayInputData.getRecipeID();
            recipe = temporaryRecipeDataAccessObject.getFromID(recipeID);
            DisplayOutputData displayOutputData = new DisplayOutputData(recipe.toString());
            displayPresenter.prepareView(displayOutputData);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
            //String errorMessage = e.getMessage();
            //displayPresenter.prepareFailView()
        }
    }
}