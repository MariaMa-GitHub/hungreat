package interface_adapter;

import java.util.HashMap;
import java.util.Map;

public class DisplayViewModel {

    private Map<Integer, String> recipes = new HashMap<>();

    public DisplayViewModel() {
    }

    public Map<Integer, String> getRecipes() {
        return recipes;
    }

    public void setRecipeIDs(Map<Integer, String> recipeIDs) {

        this.recipes = recipeIDs;

    }

}
