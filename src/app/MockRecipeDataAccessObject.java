package app;

import entity.NutritionData;
import entity.Recipe;
import entity.RecipeInfo;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.getSimilarRecipes.GetSimilarRecipesDataAccessInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MockRecipeDataAccessObject implements GetSimilarRecipesDataAccessInterface, TemporaryRecipeDataAccessInterface{

    @Override
    public ArrayList<Recipe> getSimilarRecipes(int id) {
        ArrayList<Recipe> savedRecipes = new ArrayList<>();
        Collection<String> ingredients = new ArrayList<>();
        ingredients.add("apple");
        Collection<String> instructions = new ArrayList<>();
        instructions.add("fried in pan.");
        Map<String, String> nutrients = new HashMap<>();
        nutrients.put("key", "value");
        NutritionData nutrition = new NutritionData(9, nutrients);
        RecipeInfo info = new RecipeInfo(1, 2, 3, 4, ingredients, instructions);
        Recipe giveRecipe = new Recipe(2, "title2", "url", "imageUrl", info, nutrition);
        savedRecipes.add(giveRecipe);
        return savedRecipes;}

        @Override
        public Recipe getFromID(int id) {
            return null;
        }

        @Override
        public boolean existsByID(int id) {
            return false;
        }

        @Override
        public void storeRecipes(ArrayList<Recipe> recipeList) {

        }

        @Override
        public void storeRecipe(Recipe recipe) {

        }

        @Override
        public void unStoreRecipe(Recipe recipe) {

        }

}
