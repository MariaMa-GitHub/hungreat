package entity;

import java.io.Serializable;
import java.util.Map;

public class NutritionData implements Serializable {

    private int recipeID;
    private Map<String, String> nutrients;

    public NutritionData(int recipeID, Map<String, String> nutrients) {
        this.recipeID = recipeID;
        this.nutrients = nutrients;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public Map<String, String> getNutrients() {
        return nutrients;
    }

}
