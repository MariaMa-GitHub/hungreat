package interface_adapter.save;

import interface_adapter.SaveState;
import interface_adapter.SaveViewModel;
import use_case.save.SaveOutputBoundary;
import use_case.save.SaveOutputData;


public class SavePresenter implements SaveOutputBoundary {
    private final SaveViewModel saveViewModel;

    public SavePresenter(SaveViewModel saveViewModel) {
        this.saveViewModel = saveViewModel;
    }

    @Override
    public void prepareSuccessView(SaveOutputData response) {
        SaveState state = saveViewModel.getState();
        if (response.getSavedRecipes() != null) {
            state.setSavedRecipes(response.getSavedRecipes());
            saveViewModel.setState(state);
            saveViewModel.firePropertyChanged();
        } else {
            state.add(response.getRecipeID(), response.getTitle());
            saveViewModel.setState(state);
            saveViewModel.firePropertyChanged();
        }
    }

    @Override
    public void prepareFailView(String error) {
        SaveState state = saveViewModel.getState();
        state.setError(error);
        saveViewModel.setState(state);
        saveViewModel.firePropertyChanged();
    }
}
