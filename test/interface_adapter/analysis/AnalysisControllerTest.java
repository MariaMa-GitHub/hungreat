package interface_adapter.analysis;

import data_access.TemporaryRecipeDataAccessObject;
import entity.NutritionData;
import entity.Recipe;
import entity.RecipeInfo;
import interface_adapter.analysis.AnalysisController;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.analysis.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalysisControllerTest {
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

        AnalysisInputData analysisInputData = new AnalysisInputData(9);
        AnalysisOutputBoundary successPresenter = new AnalysisOutputBoundary() {
            @Override
            public void prepareView(AnalysisOutputData recipeString) {
                assertEquals(giveRecipe.nutritionToString(), recipeString.getNutritionToString());

            }
        };
        AnalysisInputBoundary interactor = new AnalysisInteractor(temporaryRecipeDataAccessObject, successPresenter);
        AnalysisController controller = new AnalysisController(interactor);
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
        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(savedRecipes);

        AnalysisInputData analysisInputData = new AnalysisInputData(9);
        AnalysisOutputBoundary successPresenter = new AnalysisOutputBoundary() {
            @Override
            public void prepareView(AnalysisOutputData recipeString) {
                assertEquals("Analysis not available for this recipe.", recipeString.getNutritionToString());
            }
        };
        AnalysisInputBoundary interactor = new AnalysisInteractor(temporaryRecipeDataAccessObject, successPresenter);
        AnalysisController controller = new AnalysisController(interactor);
        controller.execute(9);

    }
}