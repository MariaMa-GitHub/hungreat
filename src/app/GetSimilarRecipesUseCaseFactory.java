package app;

import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.RecipeViewModel;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesPresenter;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.getSimilarRecipes.GetSimilarRecipesDataAccessInterface;
import use_case.getSimilarRecipes.GetSimilarRecipesInputBoundary;
import use_case.getSimilarRecipes.GetSimilarRecipesInteractor;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputBoundary;
import use_case.recommend.RecommendDataAccessInterface;

import javax.swing.*;
import java.io.IOException;

public class GetSimilarRecipesUseCaseFactory {
    private GetSimilarRecipesUseCaseFactory(){}
    public static GetSimilarRecipesController create(GetSimilarRecipesDataAccessInterface recipeDataAccessObject, RecipeViewModel recipeViewModel) {

        try {
            GetSimilarRecipesController getSimilarRecipesController = createGetSimilarRecipesUseCase(recipeDataAccessObject, recipeViewModel);
            return getSimilarRecipesController;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open recipe");
        }

        return null;
    }

    private static GetSimilarRecipesController createGetSimilarRecipesUseCase(GetSimilarRecipesDataAccessInterface recipeDataAccessObject, RecipeViewModel recipeViewModel) throws IOException {

        GetSimilarRecipesOutputBoundary getSimilarRecipesOutputBoundary = new GetSimilarRecipesPresenter(recipeViewModel);

        GetSimilarRecipesInputBoundary getSimilarRecipesInteractor = new GetSimilarRecipesInteractor(recipeDataAccessObject, getSimilarRecipesOutputBoundary);

        return new GetSimilarRecipesController(getSimilarRecipesInteractor);
    }
}

