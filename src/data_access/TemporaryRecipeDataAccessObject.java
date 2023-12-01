package data_access;

import entity.NutritionDataFactory;
import entity.Recipe;
import entity.RecipeFactory;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.browse.BrowseInputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TemporaryRecipeDataAccessObject implements TemporaryRecipeDataAccessInterface  {

    private final Map<Integer, Recipe> recipes = new HashMap<>();

    public TemporaryRecipeDataAccessObject(ArrayList<Recipe> savedRecipes) {
        storeRecipes(savedRecipes);

    }

    public Recipe getFromID(int id) {
        return recipes.get(id);
    }

    public boolean existsByID(int id) {
        return (recipes.containsKey(id));
    }

    public void storeRecipes(ArrayList<Recipe> recipeList) {
        recipes.clear();
        for (Recipe recipe : recipeList) {
            recipes.put(recipe.getID(), recipe);
        }
    }

    public void storeRecipe(Recipe recipe) {
        recipes.put(recipe.getID(), recipe);
    }

}
