package interface_adapter.create;

import use_case.create.CreateOutputBoundary;
import use_case.create.CreateOutputData;

public class CreatePresenter implements CreateOutputBoundary {

    @Override
    public void prepareSuccessView(CreateOutputData createOutputData) {
        // TODO: go back to home view? what is save view?
    }

    @Override
    public void prepareFailView(String error) {

    }
}
