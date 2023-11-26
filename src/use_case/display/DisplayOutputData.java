package use_case.display;

import entity.Recipe;

public class DisplayOutputData {
    private final String recipeString;
    public DisplayOutputData(String recipeString) {
        this.recipeString = recipeString;
    }
    public String getRecipeString(){
        return recipeString;
    }
}
