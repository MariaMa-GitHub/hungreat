package use_case.display;

import entity.Recipe;

public class DisplayOutputData {
    private final Recipe recipe;
    public DisplayOutputData(Recipe recipe) {
        this.recipe = recipe;
    }
    public Recipe getRecipe(){
        return recipe;
    }
}
