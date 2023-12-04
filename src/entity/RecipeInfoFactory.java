package entity;

import java.util.Collection;

public class RecipeInfoFactory {

    public RecipeInfo create(int recipeID, int servings, int readyInMinutes, int healthScore, Collection<String> ingredients, Collection<String> instructions) {
        return new RecipeInfo(recipeID, servings, readyInMinutes, healthScore, ingredients, instructions);
    }

    public RecipeInfo create( int servings, int readyInMinutes, Collection<String> ingredients, Collection<String> instructions) {
        //This is only for user-created recipes
        return new RecipeInfo(servings, readyInMinutes, ingredients, instructions);
    }

}
