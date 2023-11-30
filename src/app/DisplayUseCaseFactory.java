package app;

import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.RecipeViewModel;
import interface_adapter.display.DisplayPresenter;
import interface_adapter.display.DisplayController;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.display.DisplayInputBoundary;
import use_case.display.DisplayInteractor;
import use_case.display.DisplayOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class DisplayUseCaseFactory {
    private DisplayUseCaseFactory(){}
    public static DisplayController create(TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject,RecipeViewModel recipeViewModel) {

        try {
            DisplayController displayController = createDisplayUseCase(temporaryRecipeDataAccessObject, recipeViewModel);
            return displayController;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open recipe");
        }

        return null;
    }

    private static DisplayController createDisplayUseCase(TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject,RecipeViewModel recipeViewModel) throws IOException{

        DisplayOutputBoundary displayOutputBoundary = new DisplayPresenter(recipeViewModel);

        DisplayInputBoundary displayInteractor = new DisplayInteractor(temporaryRecipeDataAccessObject, displayOutputBoundary);

        return new DisplayController(displayInteractor);
    }
}
