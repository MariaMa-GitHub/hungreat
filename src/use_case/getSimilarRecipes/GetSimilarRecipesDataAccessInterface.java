package use_case.getSimilarRecipes;

import entity.Recipe;

import java.util.ArrayList;

public interface GetSimilarRecipesDataAccessInterface {
    ArrayList<Recipe> getSimilarRecipes(int id);
}
