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
    public void prepareSuccessView(SaveOutputData Title) {
        System.out.println("Recipe saved successfully!");
    }

    @Override
    public void prepareFailView(String error) {
        System.err.println("Error occurred: " + error);
    }
}
