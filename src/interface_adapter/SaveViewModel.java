package interface_adapter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

public class SaveViewModel {

    private SaveState state = new SaveState();

    public void setState(SaveState state) {
        this.state = state;
    }

    public SaveState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

//    public void successFirePropertyChanged() {
//        support.firePropertyChange("savedRecipes", null, this.savedRecipes);
//    }
//
//    public void failFirePropertyChanged() {
//        support.firePropertyChange("error", null, this.error);
//    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
