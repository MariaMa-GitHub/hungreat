package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Map;

public class SaveViewModel {
    private Map<Integer, String> savedRecipes;
    private String error;

    public SaveViewModel() {
    }

    public Map<Integer, String> getSavedRecipes() {
        return savedRecipes;
    }

    public void setSavedRecipes(Map<Integer, String> savedRecipesg) {
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

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void successFirePropertyChanged() {
        // TODO: Check whether null is appropriate for the first argument
        support.firePropertyChange("savedRecipes", null, this.savedRecipes);
    }

    public void failFirePropertyChanged() {
        // TODO: Check whether null is appropriate for the first argument
        support.firePropertyChange("error", null, this.error);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
