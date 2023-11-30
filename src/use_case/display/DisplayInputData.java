package use_case.display;

import entity.Recipe;

public class DisplayInputData {
    final private Integer recipeID;

    public DisplayInputData(Integer recipeID){
        this.recipeID = recipeID;
    }
    public Integer getRecipeID(){
        return recipeID;
    }
}
