package interface_adapter;

import java.sql.SQLOutput;

public class RecipeViewModel{
    private String recipeString;
    //因为在main create RecipeViewModel 时不知道 RecipeViewModel
    // 里要pass in 什么variable 所以这里initialize为空，
    // 用set method 去initialize.
    public RecipeViewModel() {
    }

    public void setRecipeString(String recipeString) {
        this.recipeString = recipeString;
    }

    public String getRecipeString() {
//        System.out.println(recipeString);
            return recipeString;
    }
}
