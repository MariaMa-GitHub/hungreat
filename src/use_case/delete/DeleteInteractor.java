package use_case.delete;

import entity.Recipe;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.delete.DeleteDataAccessInterface;
import use_case.delete.DeleteInputBoundary;
import use_case.delete.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeleteInteractor implements DeleteInputBoundary {
    final DeleteOutputBoundary deleteOutputBoundary;
    final TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessInterface;
    final DeleteDataAccessInterface deletedRecipeDataAccessInterface;

    public DeleteInteractor(DeleteOutputBoundary deleteOutputBoundary, TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessInterface, DeleteDataAccessInterface deletedRecipeDataAccessInterface) {
        this.deleteOutputBoundary = deleteOutputBoundary;
        this.temporaryRecipeDataAccessInterface = temporaryRecipeDataAccessInterface;
        this.deletedRecipeDataAccessInterface = deletedRecipeDataAccessInterface;
    }

    @Override
    public void execute(DeleteInputData deleteInputData) throws IOException, ClassNotFoundException {
        Integer recipeID = deleteInputData.getRecipeID();
            try {
                Recipe deleteRecipe = temporaryRecipeDataAccessInterface.getFromID(recipeID);
                deletedRecipeDataAccessInterface.delete(deleteRecipe);

                DeleteOutputData deleteOutputData = new DeleteOutputData(deleteRecipe.getID(),deleteRecipe.getTitle());
                deleteOutputBoundary.prepareSuccessView(deleteOutputData);

            } catch (Exception e) {
                String errorMessage = e.getMessage();
                deleteOutputBoundary.prepareFailView(errorMessage);
            }

        }
    }

