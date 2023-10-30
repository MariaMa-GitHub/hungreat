package data_access;

import entity.BrowseFilter;
import entity.Recipe;
import entity.RecipeInfo;
import use_case.browse.BrowseDataAccessInterface;
import use_case.recommend.RecommendDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecipeDataAccessObject implements BrowseDataAccessInterface, RecommendDataAccessInterface {
    private final Map<String, Recipe> savedRecipes = new HashMap<>();

    @Override
    public ArrayList<Recipe> browse(BrowseFilter browseFilter) {
        return null;
    }

    public RecipeInfo getRecipeInfo(int recipeID){
        return null;
    }
}
