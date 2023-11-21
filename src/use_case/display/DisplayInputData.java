package use_case.display;

import entity.Recipe;

public class DisplayInputData {
    final private Recipe recipe;

    public DisplayInputData(Recipe recipe){
        this.recipe = recipe;
    }
    public Recipe getRecipe(Recipe recipe){
        return recipe;
    }
}
