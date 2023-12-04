package interface_adapter.create;

import interface_adapter.SaveViewModel;
import use_case.create.CreateOutputBoundary;
import use_case.create.CreateOutputData;

public class CreatePresenter implements CreateOutputBoundary {

    private  final SaveViewModel saveViewModel;

    public CreatePresenter(SaveViewModel saveViewModel) {
        this.saveViewModel = saveViewModel;
    }

    @Override
    public void prepareSuccessView(CreateOutputData createOutputData) {
        saveViewModel.add(createOutputData.getId(), createOutputData.getTitle());
        saveViewModel.successFirePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        saveViewModel.setError(error);
        saveViewModel.failFirePropertyChanged();
    }
}
