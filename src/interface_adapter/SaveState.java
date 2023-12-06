package interface_adapter;

import java.util.HashMap;
import java.util.Map;

public class SaveState {

    private Map<Integer, String> savedRecipes;
    private String error;

    public SaveState() {
        this.savedRecipes = new HashMap<>();
        this.error = "";
    }

    public Map<Integer, String> getSavedRecipes() {
        return savedRecipes;
    }

    public void setSavedRecipes(Map<Integer, String> savedRecipes) {
        this.savedRecipes = savedRecipes;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void add(Integer recipeID, String title) {
        savedRecipes.put(recipeID, title);
    }
    public void remove(Integer recipeID) {
        savedRecipes.remove(recipeID);
    }

}
