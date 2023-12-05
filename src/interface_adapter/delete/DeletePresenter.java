package interface_adapter.delete;

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
        saveViewModel.remove(deleteOutputData.getRecipeID());
        saveViewModel.successFirePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        saveViewModel.setEorrorForDelete(error);
    }
}

