package entity;

import java.util.Collection;

public class RecipeInfo {

    private int recipeID;
    private int servings;
    private int readyInMinutes;
    private int healthScore;
    private Collection<String> ingredients;
    private Collection<String> instructions;

    public RecipeInfo(int recipeID, int servings, int readyInMinutes, int healthScore, Collection<String> ingredients, Collection<String> instructions) {
        this.recipeID = recipeID;
        this.servings = servings;
        this.readyInMinutes = readyInMinutes;
        this.healthScore = healthScore;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public int getServings() {
        return servings;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public Collection<String> getIngredients() {
        return ingredients;
    }

    public Collection<String> getInstructions() {
        return instructions;
    }

}
