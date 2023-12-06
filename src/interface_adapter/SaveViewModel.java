package interface_adapter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

public class SaveViewModel {
    private Map<Integer, String> savedRecipes;
    private String error;

    public SaveViewModel() {
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

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void successFirePropertyChanged() {
        support.firePropertyChange("savedRecipes", null, this.savedRecipes);
    }

    public void failFirePropertyChanged() {
        support.firePropertyChange("error", null, this.error);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
