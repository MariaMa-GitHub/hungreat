package use_case.save;

import entity.Recipe;
import use_case.TemporaryRecipeDataAccessInterface;

import java.util.ArrayList;

public class SaveInteractor implements SaveInputBoundary {
    final SaveOutputBoundary saveOutputBoundary;
    final TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessInterface;
    final SaveDataAccessInterface savedRecipeDataAccessInterface;

    public SaveInteractor(SaveOutputBoundary saveOutputBoundary, TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessInterface, SaveDataAccessInterface savedRecipeDataAccessInterface) {
        this.saveOutputBoundary = saveOutputBoundary;
        this.temporaryRecipeDataAccessInterface = temporaryRecipeDataAccessInterface;
        this.savedRecipeDataAccessInterface = savedRecipeDataAccessInterface;
    }

    // TODO: Call the storeRecipe method from TemporaryRecipeDataAccessObject
    // TODO: Call the save method from SavedRecipeDataAccessObject
    @Override
    public void execute(SaveInputData saveInputData) {
        Integer recipeID = saveInputData.getRecipeID();
        Recipe saveRecipeTitle = temporaryRecipeDataAccessInterface.getFromID(recipeID);
        try{
            savedRecipeDataAccessInterface.save(saveRecipeTitle);
            SaveOutputData saveOutputData = new SaveOutputData(recipeID, saveRecipeTitle.getTitle());
            saveOutputBoundary.prepareSuccessView(saveOutputData);
        }
        catch (Exception e){
            String errorMessage = e.getMessage();
            saveOutputBoundary.prepareFailView(errorMessage);
        }
    }

//    @Override
//    public void execute() {
//
//    }
}
