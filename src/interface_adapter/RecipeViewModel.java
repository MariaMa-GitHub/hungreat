package interface_adapter;

import java.sql.SQLOutput;

public class RecipeViewModel{
    private String recipeString;
    // cause we do not know what variable we need to pass in while we create RecipeViewModel in main
    // so here initializer is empty , we use set method to initialize RecipeViewModel.
    public RecipeViewModel() {
    }

    public void setRecipeString(String recipeString) {
        this.recipeString = recipeString;
    }

    public String getRecipeString() {
            return recipeString;
    }
}
