package interface_adapter.create;

import interface_adapter.SaveState;
import interface_adapter.SaveViewModel;
import use_case.create.CreateOutputBoundary;
import use_case.create.CreateOutputData;

public class CreatePresenter implements CreateOutputBoundary {

    private final SaveViewModel saveViewModel;

    public CreatePresenter(SaveViewModel saveViewModel) {
        this.saveViewModel = saveViewModel;
    }

    @Override
    public void prepareSuccessView(CreateOutputData createOutputData) {
        SaveState state = saveViewModel.getState();
        state.add(createOutputData.getId(), createOutputData.getTitle());
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
