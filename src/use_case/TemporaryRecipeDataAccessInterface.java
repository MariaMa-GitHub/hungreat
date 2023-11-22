package use_case;

import entity.Recipe;
import entity.RecommendFilter;

import java.util.ArrayList;

public interface TemporaryRecipeDataAccessInterface {

    Recipe getFromID(int id);

    void storeRecipes(ArrayList<Recipe> recipeList);

}
