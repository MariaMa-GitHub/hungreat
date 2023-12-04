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
    public void execute(DisplayInputData displayInputData){

        Integer recipeID =  displayInputData.getRecipeID();
        Recipe recipe = temporaryRecipeDataAccessObject.getFromID(recipeID);
        if (recipe != null){
        DisplayOutputData displayOutputData = new DisplayOutputData(recipe.toString());
        displayPresenter.prepareView(displayOutputData);}

        else{
        DisplayOutputData displayOutputData = new DisplayOutputData("Recipe dose not exist.");
        displayPresenter.prepareView(displayOutputData);}

    }
}