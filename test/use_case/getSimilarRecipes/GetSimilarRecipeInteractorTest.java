package use_case.getSimilarRecipes;

import app.MockRecipeDataAccessObject;
import entity.NutritionData;
import entity.Recipe;
import entity.RecipeInfo;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetSimilarRecipeInteractorTest {
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

        GetSimilarRecipesInputData getSimilarRecipesInputData = new GetSimilarRecipesInputData(9);
        GetSimilarRecipesOutputBoundary successPresenter = new GetSimilarRecipesOutputBoundary() {
            @Override
            public void prepareView(GetSimilarRecipesOutputData recipeString) {
                assertEquals("title2"+"\n", recipeString.getTitle());

            }
        };
        GetSimilarRecipesInputBoundary interactor = new GetSimilarRecipesInteractor(mockRecipeDataAccessObject, successPresenter);
        GetSimilarRecipesController controller = new GetSimilarRecipesController(interactor);
        controller.execute(9);

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

        GetSimilarRecipesInputData getSimilarRecipesInputData = new GetSimilarRecipesInputData(-1);
        GetSimilarRecipesOutputBoundary successPresenter = new GetSimilarRecipesOutputBoundary() {
            @Override
            public void prepareView(GetSimilarRecipesOutputData recipeString) {
                assertEquals("No similar recipes found.", recipeString.getTitle());
            }
        };
        GetSimilarRecipesInputBoundary interactor = new GetSimilarRecipesInteractor(mockRecipeDataAccessObject,  successPresenter);
        GetSimilarRecipesController controller = new GetSimilarRecipesController(interactor);
        controller.execute(-1);

    }
}
