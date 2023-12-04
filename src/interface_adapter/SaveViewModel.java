package interface_adapter;

import java.util.Map;

public class SaveViewModel {
    private String title;
    private Map<Integer, String> savedRecipes;

    public SaveViewModel() {
    }

    public Map<Integer, String> getSavedRecipes() {
        return savedRecipes;
    }

    public void setSavedRecipes(Map<Integer, String> savedRecipes) {
        this.savedRecipes = savedRecipes;
    }

    public void add(Integer recipeID, String title) {
        savedRecipes.put(recipeID, title);
    }
}
