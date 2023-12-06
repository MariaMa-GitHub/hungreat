package interface_adapter.save;

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
        if (response.getSavedRecipes() != null) {
            saveViewModel.setSavedRecipes(response.getSavedRecipes());
            saveViewModel.successFirePropertyChanged();
        } else {
            saveViewModel.add(response.getRecipeID(), response.getTitle());
            saveViewModel.successFirePropertyChanged();
        }
    }

    @Override
    public void prepareFailView(String error) {
        saveViewModel.setError(error);
        saveViewModel.failFirePropertyChanged();
    }
}
