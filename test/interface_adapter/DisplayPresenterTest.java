package interface_adapter;

import data_access.TemporaryRecipeDataAccessObject;
import entity.NutritionData;
import entity.Recipe;
import entity.RecipeInfo;
import entity.RecipeInfoTest;
import interface_adapter.display.DisplayController;
import interface_adapter.display.DisplayPresenter;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.display.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayPresenterTest {
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


        RecipeViewModel recipeViewModel = new RecipeViewModel();
        DisplayOutputBoundary successPresenter = new DisplayPresenter(recipeViewModel);


        DisplayInputBoundary interactor = new DisplayInteractor(temporaryRecipeDataAccessObject, successPresenter);
        DisplayController controller = new DisplayController(interactor);
        controller.execute(9);
        assertEquals(giveRecipe.toString(), recipeViewModel.getRecipeString());

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



        RecipeViewModel recipeViewModel = new RecipeViewModel();
        DisplayOutputBoundary successPresenter = new DisplayPresenter(recipeViewModel);
        DisplayInputBoundary interactor = new DisplayInteractor(temporaryRecipeDataAccessObject, successPresenter);
        DisplayController controller = new DisplayController(interactor);
        controller.execute(9);
        assertEquals("Recipe dose not exist.", recipeViewModel.getRecipeString());

    }
}
