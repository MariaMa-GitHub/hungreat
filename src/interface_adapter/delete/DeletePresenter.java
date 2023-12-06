package interface_adapter.delete;

import interface_adapter.SaveState;
import use_case.delete.DeleteOutputBoundary;
import use_case.delete.DeleteOutputData;
import interface_adapter.SaveViewModel;

public class DeletePresenter implements DeleteOutputBoundary {

    private final SaveViewModel saveViewModel;

    public DeletePresenter( SaveViewModel saveViewModel) {
        this.saveViewModel = saveViewModel;

    }
    
    @Override
    public void prepareSuccessView(DeleteOutputData deleteOutputData) {
        SaveState state = saveViewModel.getState();
        state.remove(deleteOutputData.getRecipeID());
        saveViewModel.setState(state);
        saveViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SaveState state = saveViewModel.getState();
        state.setError(error);
        saveViewModel.setState(state);
        saveViewModel.firePropertyChanged();
    }
}

