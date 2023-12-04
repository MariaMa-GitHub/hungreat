package use_case.display;

import data_access.TemporaryRecipeDataAccessObject;
import entity.NutritionData;
import entity.Recipe;
import entity.RecipeInfo;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayInteractorTest {
    @Test
    void successTest() {
        Collection<String> ingredients = new ArrayList<>();
        ingredients.add("apple");
        Collection<String> instructions = new ArrayList<>();
        instructions.add("fried in pan.");
        Map<String, String> nutrients = new HashMap<>();
        nutrients.put("key", "value");
        NutritionData nutrition = new NutritionData(9, nutrients);
        RecipeInfo info = new RecipeInfo(1, 2, 3, 4, ingredients, instructions);
        Recipe giveRecipe = new Recipe(9, "title", "url", "imageUrl", info, nutrition);
        ArrayList<Recipe> savedRecipes = new ArrayList<>();
        savedRecipes.add(giveRecipe);
        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(savedRecipes);

        DisplayInputData displayInputData = new DisplayInputData(9);
        DisplayOutputBoundary successPresenter = new DisplayOutputBoundary() {
            @Override
            public void prepareView(DisplayOutputData recipeString) {
                assertEquals(giveRecipe.toString(), recipeString.getRecipeString());

            }
        };
        DisplayInputBoundary interactor = new DisplayInteractor(temporaryRecipeDataAccessObject, successPresenter);
        interactor.execute(displayInputData);

    }
    @Test
    void failTest() {
        Collection<String> ingredients = new ArrayList<>();
        ingredients.add("apple");
        Collection<String> instructions = new ArrayList<>();
        instructions.add("fried in pan.");
        Map<String, String> nutrients = new HashMap<>();
        nutrients.put("key", "value");
        NutritionData nutrition = new NutritionData(9, nutrients);
        RecipeInfo info = new RecipeInfo(1, 2, 3, 4, ingredients, instructions);
        Recipe recipe = new Recipe(0, "title", "url", "imageUrl", info, nutrition);
        ArrayList<Recipe> savedRecipes = new ArrayList<>();
        savedRecipes.add(recipe);
        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(savedRecipes);

        DisplayInputData displayInputData = new DisplayInputData(9);
        DisplayOutputBoundary successPresenter = new DisplayOutputBoundary() {
            @Override
            public void prepareView(DisplayOutputData recipeString) {
                assertEquals("Recipe dose not exist.", recipeString.getRecipeString());
            }
        };
        DisplayInputBoundary interactor = new DisplayInteractor(temporaryRecipeDataAccessObject, successPresenter);
        interactor.execute(displayInputData);

    }
}

