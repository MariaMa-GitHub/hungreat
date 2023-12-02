package interface_adapter;

import java.sql.SQLOutput;
import java.util.Map;

public class RecipeViewModel{
    private String recipeString;
    private Map<Integer, String> idTittle;

    // cause we do not know what variable we need to pass in while we create RecipeViewModel in main
    // so here initializer is empty , we use set method to initialize RecipeViewModel.
    public RecipeViewModel() {
    }

    public void setRecipeString(String recipeString) {
        this.recipeString = recipeString;
    }

    public void setIdTittle(Map<Integer, String> idTittle) {
        this.idTittle = idTittle;
    }

    public String getRecipeString() {
            return recipeString;
    }

    public String getTittle() {
        return idTittle.values().toString();
    }
}
