package use_case.save;

import java.util.Map;

public class SaveOutputData {
    private final Integer recipeID;
    private final String title;

    private Map<Integer, String> savedRecipes;

    public SaveOutputData(Map<Integer, String> savedRecipes) {
        this.savedRecipes = savedRecipes;
        this.recipeID = null;
        this.title = null;
    }

    public SaveOutputData(Integer recipeID, String title) {
        this.recipeID = recipeID;
        this.title = title;
        this.savedRecipes = null;
    }

    public Map<Integer, String> getSavedRecipes() {
        return savedRecipes;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public String getTitle() {
        return title;
    }
}
