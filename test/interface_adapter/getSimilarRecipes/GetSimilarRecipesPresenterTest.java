package interface_adapter.getSimilarRecipes;

import app.MockRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.NutritionData;
import entity.Recipe;
import entity.RecipeInfo;
import interface_adapter.RecipeViewModel;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesPresenter;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.getSimilarRecipes.GetSimilarRecipesDataAccessInterface;
import use_case.getSimilarRecipes.GetSimilarRecipesInputBoundary;
import use_case.getSimilarRecipes.GetSimilarRecipesInteractor;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputBoundary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetSimilarRecipesPresenterTest {
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
        GetSimilarRecipesDataAccessInterface mockRecipeDataAccessObject = new MockRecipeDataAccessObject();


        RecipeViewModel recipeViewModel = new RecipeViewModel();
        GetSimilarRecipesOutputBoundary successPresenter = new GetSimilarRecipesPresenter(recipeViewModel);


        GetSimilarRecipesInputBoundary interactor = new GetSimilarRecipesInteractor(mockRecipeDataAccessObject, successPresenter);
        GetSimilarRecipesController controller = new GetSimilarRecipesController(interactor);
        controller.execute(9);
        assertEquals("title2"+"\n", recipeViewModel.getTittle());


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
        GetSimilarRecipesDataAccessInterface mockRecipeDataAccessObject = new MockRecipeDataAccessObject();


        RecipeViewModel recipeViewModel = new RecipeViewModel();
        GetSimilarRecipesOutputBoundary successPresenter = new GetSimilarRecipesPresenter(recipeViewModel);
        GetSimilarRecipesInputBoundary interactor = new GetSimilarRecipesInteractor(mockRecipeDataAccessObject, successPresenter);
        GetSimilarRecipesController controller = new GetSimilarRecipesController(interactor);
        controller.execute(-1);
        assertEquals("No similar recipes found.", recipeViewModel.getTittle());

    }
}
