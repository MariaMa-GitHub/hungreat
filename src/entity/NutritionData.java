package entity;

import java.util.Map;

public class NutritionData {

    private int recipeID;
    private Map<String[], Float> nutrients;

    public NutritionData(int recipeID, Map<String[], Float> nutrients) {
        this.recipeID = recipeID;
        this.nutrients = nutrients;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public Map<String[], Float> getNutrients() {
        return nutrients;
    }

}
