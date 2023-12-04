package use_case.create;

import entity.Recipe;
import entity.RecipeFactory;
import entity.RecipeInfo;
import entity.RecipeInfoFactory;

import java.io.IOException;
import java.util.ArrayList;

public class CreateInteractor implements CreateInputBoundary {

    final CreateDataAccessInterface dataAccessObject;
    final CreateOutputBoundary createPresenter;
    final RecipeFactory recipeFactory;
    final RecipeInfoFactory recipeInfoFactory;

    public CreateInteractor(
            CreateDataAccessInterface dataAccessObject,
            CreateOutputBoundary createPresenter,
            RecipeFactory recipeFactory,
            RecipeInfoFactory recipeInfoFactory) {
        this.dataAccessObject = dataAccessObject;
        this.createPresenter = createPresenter;
        this.recipeFactory = recipeFactory;
        this.recipeInfoFactory = recipeInfoFactory;
    }

    public void execute(CreateInputData createInputData) {
        //
        String title = createInputData.getTitle();
        int servings = createInputData.getServings();
        int readyInMinutes = createInputData.getReadyInMinutes();
        ArrayList<String> ingredients = createInputData.getIngredients();
        ArrayList<String> instructions = createInputData.getInstructions();

        if (servings == -1) {
            createPresenter.prepareFailView("Please enter an integer for servings.");
        } else if (readyInMinutes == -1) {
            createPresenter.prepareFailView("Please enter an Integer for cooking time.");
        } else {
            RecipeInfo recipeInfo = recipeInfoFactory.create(servings, readyInMinutes, ingredients, instructions);
            Recipe recipe = recipeFactory.create(recipeInfo.getRecipeID(), title, recipeInfo);
            Integer id = recipe.getID();

            try {
                dataAccessObject.save(recipe);
            } catch (IOException | ClassNotFoundException e) {
                createPresenter.prepareFailView("Unable to Save.");
                //TODO update after exceptions in savedDAO has been handled
            }

            CreateOutputData createOutputData = new CreateOutputData(id, title);
            createPresenter.prepareSuccessView(createOutputData);
        }


    }
}